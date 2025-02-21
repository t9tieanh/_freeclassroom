package com.freeclassroom.freeclassroom.mapper;

import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.entity.user.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toStudentEntity(UserCreationRequest request);

    UserCreationResponse toUserCreationResponse(StudentEntity studentEntity);
}
