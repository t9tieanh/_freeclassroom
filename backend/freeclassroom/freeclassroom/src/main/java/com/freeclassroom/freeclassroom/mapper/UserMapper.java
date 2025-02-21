//package com.freeclassroom.freeclassroom.mapper;
//
//import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
//import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
//import com.freeclassroom.freeclassroom.entity.user.StudentEntity;
//import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
//import com.freeclassroom.freeclassroom.entity.user.UserEntity;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.mapstruct.Mapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@FieldDefaults(level = AccessLevel.PUBLIC)
//public class UserMapper {
//    TeacherEntity toTeacherEntity (UserCreationRequest request){
//        if (request == null) return null;
//
//        return (TeacherEntity) TeacherEntity.builder()
//                .image(request.getImage())
//                .phone(request.getPhone())
//                .name(request.getName())
//                .build();
//    }
//
//    StudentEntity toStudentEntity (UserCreationRequest request){
//        if (request == null) return null;
//
//        return (StudentEntity) TeacherEntity.builder()
//                .image(request.getImage())
//                .phone(request.getPhone())
//                .name(request.getName())
//                .build();
//    }
//
//    UserCreationRequest userCreationRequest (TeacherEntity teacherEntity){
//        if (teacherEntity == null) return null;
//
//        return UserCreationRequest.builder()
//                .image(teacherEntity.getImage())
//                .phone(teacherEntity.getPhone())
//                .name(teacherEntity.getName())
//                .build();
//    }
//
//    UserCreationRequest userCreationRequest (StudentEntity studentEntity){
//        if (studentEntity == null) return null;
//
//        return UserCreationRequest.builder()
//                .image(studentEntity.getImage())
//                .phone(studentEntity.getPhone())
//                .name(studentEntity.getName())
//                .build();
//    }
//}
