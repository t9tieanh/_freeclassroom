package com.freeclassroom.freeclassroom.service.auth;

import com.freeclassroom.freeclassroom.dto.request.AuthenticationRequest;
import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.AuthenticationResponse;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
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
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import com.freeclassroom.freeclassroom.utils.JwtUtils;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class AuthenticationService {

    AccountRepository accountRepository;
    TeacherRepository teacherRepository;
    StudentRespository studentRepository;

    AccountMapper accountMapper;
    TeacherMapper teacherMapper;
    StudentMapper studentMapper;

    PasswordEncoder passwordEncoder;
    JwtUtils jwtUtils;

    FileStorageService fileStorageService;

    public AuthenticationResponse authentication (AuthenticationRequest request) throws JOSEException {
        AccountEntity account = (AccountEntity) accountRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new CustomExeption(ErrorCode.USER_NOT_FOUND)
        );

        boolean result = passwordEncoder.matches(request.getPassword(), account.getPassword());

        if (result) {
            return AuthenticationResponse.builder()
                    .token(jwtUtils.generateToken(account))
                    .valid(true)
                    .build();
        }

        throw new CustomExeption(ErrorCode.UN_AUTHENTICATED);
    }


    public UserCreationResponse signUp (UserCreationRequest userCreationRequest) throws IOException {

        if (accountRepository.existsByEmail(userCreationRequest.getEmail()) ||
            accountRepository.existsByUsername(userCreationRequest.getUsername()) ){
            throw new CustomExeption(ErrorCode.USER_EXISTED);
        }

        // lưu ảnh người dùng
        if (userCreationRequest.getImageFile() != null)
            userCreationRequest.setImage(fileStorageService.storeImage(userCreationRequest.getImageFile()));
        //

        userCreationRequest.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));

        if (userCreationRequest.getRole() == EnumRole.STUDENT)
           return signUpForStudent(userCreationRequest);
        else if (userCreationRequest.getRole() == EnumRole.TEACHER)
            return signUpForTeacher(userCreationRequest);
        else throw new CustomExeption(ErrorCode.INVALID_KEY);

    }

    @Transactional
    protected UserCreationResponse signUpForStudent(UserCreationRequest userCreationRequest) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(userCreationRequest);
        StudentEntity studentEntity = (StudentEntity) studentMapper.toStudentEntity(userCreationRequest);

        UserCreationResponse userCreationResponse;
        // tiến hành lưu student
        userCreationResponse = studentMapper.toUserCreationResponse(studentRepository.save(studentEntity));
        AccountEntity newAccount = accountRepository.save(accountEntity);

        accountMapper.updateAccountResponse(newAccount, userCreationResponse);

        return userCreationResponse;
    }

    @Transactional
    protected UserCreationResponse signUpForTeacher(UserCreationRequest userCreationRequest) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(userCreationRequest);
        TeacherEntity teacherEntity = (TeacherEntity) teacherMapper.toTeacherEntity(userCreationRequest);

        UserCreationResponse userCreationResponse = null;

        userCreationResponse = teacherMapper.toUserCreationResponse(teacherRepository.save(teacherEntity));
        AccountEntity newAccount = accountRepository.save(accountEntity);

        accountMapper.updateAccountResponse(newAccount, userCreationResponse);

        return userCreationResponse;
    }

}
