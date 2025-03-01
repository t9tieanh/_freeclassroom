package com.freeclassroom.freeclassroom.mapper;

import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.TeacherResponse;
import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherEntity toTeacherEntity (UserCreationRequest request);
    UserCreationResponse toUserCreationResponse (TeacherEntity entity);
    TeacherResponse toTeacherResponse (TeacherEntity entity);
}
