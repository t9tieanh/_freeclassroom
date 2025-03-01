package com.freeclassroom.freeclassroom.mapper.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.FileCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.FileCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.post.FileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    FileEntity toEntity(FileCreationRequest file);
    FileCreationResponse toResponse(FileEntity entity);
}
