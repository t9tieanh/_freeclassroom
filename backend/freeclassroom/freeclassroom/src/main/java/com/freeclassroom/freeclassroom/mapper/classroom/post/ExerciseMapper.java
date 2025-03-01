package com.freeclassroom.freeclassroom.mapper.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.ExerciseCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.ExerciseCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.post.ExerciseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseEntity toEntity (ExerciseCreationRequest request);
    ExerciseCreationResponse toResponse (ExerciseEntity entity);
}
