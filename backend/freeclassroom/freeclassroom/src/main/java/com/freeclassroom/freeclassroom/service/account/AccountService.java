package com.freeclassroom.freeclassroom.service.account;

import com.freeclassroom.freeclassroom.dto.request.ActiveAccountRequest;
import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.VerifyOtpRequest;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.VerifyOtpResponse;
import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.entity.account.EnumAccountStatus;
import com.freeclassroom.freeclassroom.entity.account.EnumRole;
import com.freeclassroom.freeclassroom.entity.user.StudentEntity;
import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.AccountMapper;
import com.freeclassroom.freeclassroom.mapper.StudentMapper;
import com.freeclassroom.freeclassroom.mapper.TeacherMapper;
import com.freeclassroom.freeclassroom.repository.AccountRepository;
import com.freeclassroom.freeclassroom.repository.StudentRespository;
import com.freeclassroom.freeclassroom.repository.TeacherRepository;
import com.freeclassroom.freeclassroom.repository.httpclient.OutboundAuthenticateClient;
import com.freeclassroom.freeclassroom.repository.httpclient.OutboundUserInfoClient;
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import com.freeclassroom.freeclassroom.service.utils.OtpService;
import com.freeclassroom.freeclassroom.utils.JwtUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {

    AccountRepository accountRepository;
    TeacherRepository teacherRepository;
    StudentRespository studentRepository;

    AccountMapper accountMapper;
    TeacherMapper teacherMapper;
    StudentMapper studentMapper;

    PasswordEncoder passwordEncoder;

    OtpService otpService;

    FileStorageService fileStorageService;

    public boolean ActiveGGAccount (UserCreationRequest request) throws IOException {
        AccountEntity account = accountRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new CustomExeption(ErrorCode.USER_NOT_FOUND)
        );

        // lưu ảnh người dùng
        if (request.getImageFile() != null)
            request.setImage(fileStorageService.storeImage(request.getImageFile()));

        // mã hóa pass và set status
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setStatus(EnumAccountStatus.ACTIVE);

        accountMapper.updateAccountEntity(request,account); // update infomation

        // lưu vào db
        if (request.getRole() == EnumRole.STUDENT) {
            var studentEntity = studentMapper.toStudentEntity(request);
            studentEntity.setAccount(account);
            account.setStudent(studentEntity);

        } else if (request.getRole() == EnumRole.TEACHER) {
            var teacherEntity = teacherMapper.toTeacherEntity(request);
            teacherEntity.setAccount(account);
            account.setTeacher(teacherEntity);
        } else throw  new CustomExeption(ErrorCode.USER_NOT_FOUND);

        accountRepository.save(account);
        return true;
    }

    public UserCreationResponse signUp (UserCreationRequest userCreationRequest) throws IOException {

        if (accountRepository.existsByEmail(userCreationRequest.getEmail()) ||
                accountRepository.existsByUsername(userCreationRequest.getUsername()) ){
            throw new CustomExeption(ErrorCode.USER_EXISTED);
        }

        // lưu ảnh người dùng
        if (userCreationRequest.getImageFile() != null)
            userCreationRequest.setImage(fileStorageService.storeImage(userCreationRequest.getImageFile()));

        // mã hóa pass và set status
        userCreationRequest.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        userCreationRequest.setStatus(EnumAccountStatus.NOT_ACTIVE);

        UserCreationResponse userCreationResponse;

        // lưu vào db
        userCreationResponse = (userCreationRequest.getRole() == EnumRole.STUDENT) ? signUpForStudent(userCreationRequest)
                : signUpForTeacher(userCreationRequest);

        // tạo otp và gửi chúng đi xác nhân
        otpService.createOTP(userCreationResponse.getEmail());

        return userCreationResponse;
    }

    @Transactional
    protected UserCreationResponse signUpForStudent(UserCreationRequest userCreationRequest) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(userCreationRequest);
        StudentEntity studentEntity = studentMapper.toStudentEntity(userCreationRequest);

        UserCreationResponse userCreationResponse;
        // tiến hành lưu student

        studentEntity = studentRepository.save(studentEntity);

        // lưu account
//        accountEntity.setStudent(studentEntity);
        studentEntity.setAccount(accountEntity);
        AccountEntity newAccount = accountRepository.save(accountEntity);

        userCreationResponse = studentMapper.toUserCreationResponse(studentEntity);
        accountMapper.updateAccountResponse(newAccount, userCreationResponse);

        return userCreationResponse;
    }

    @Transactional
    protected UserCreationResponse signUpForTeacher(UserCreationRequest userCreationRequest) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(userCreationRequest);
        TeacherEntity teacherEntity = teacherMapper.toTeacherEntity(userCreationRequest);

        UserCreationResponse userCreationResponse;
        // tiến hành lưu teacher

        teacherEntity = teacherRepository.save(teacherEntity);

        // lưu account
        accountEntity.setTeacher(teacherEntity);
        teacherEntity.setAccount(accountEntity);
        AccountEntity newAccount = accountRepository.save(accountEntity);

        userCreationResponse = teacherMapper.toUserCreationResponse(teacherEntity);
        accountMapper.updateAccountResponse(newAccount, userCreationResponse);

        return userCreationResponse;
    }

    public VerifyOtpResponse verifyOTP (VerifyOtpRequest request) {

        boolean result = otpService.validateOtp(request.getOtp());

        if (!result) throw new CustomExeption(ErrorCode.NOT_VERIFY_OTP);

        AccountEntity account = accountRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new CustomExeption(ErrorCode.USER_NOT_FOUND)
        );
        account.setStatus(EnumAccountStatus.ACTIVE);
        accountRepository.save(account);

        return VerifyOtpResponse.builder()
                .valid(result)
                .build();
    }



}
