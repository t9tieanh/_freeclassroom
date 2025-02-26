package com.freeclassroom.freeclassroom.service.classroom;

import com.freeclassroom.freeclassroom.dto.request.ClassRoomCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ClassRoomCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.ClassRoomMapper;
import com.freeclassroom.freeclassroom.repository.ClassRoomRepository;
import com.freeclassroom.freeclassroom.repository.TeacherRepository;
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ClassRoomService {
    ClassRoomRepository classRoomRepository;
    TeacherRepository teacherRepository;
    ClassRoomMapper classRoomMapper;

    public ClassRoomCreationResponse addClassRoom(ClassRoomCreationRequest request) throws IOException {

        TeacherEntity teacherEntity = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_EXISTED));

        ClassRoomEntity classRoomEntity = classRoomMapper.toClassRoomEntity(request);
        classRoomEntity.setTeacher(teacherEntity);

        return classRoomMapper.toClassRoomCreationResponse(
                classRoomRepository.save(classRoomEntity)
        );
    }

    public Page<ClassRoomCreationResponse> getClassRoom(String teacherUsername, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);

        Page<ClassRoomEntity> classRooms = classRoomRepository.findByUsernameTeacher
                (teacherUsername, pageable);

        return classRooms.map(classRoomMapper::toClassRoomCreationResponse);
    }



}
