package com.freeclassroom.freeclassroom.mapper.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.NoticeCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.PostResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.NoticeCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.post.NoticeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoticeMapper {
    NoticeEntity toEntity(NoticeCreationRequest request);
    NoticeCreationResponse toResponse(NoticeEntity entity);
}
