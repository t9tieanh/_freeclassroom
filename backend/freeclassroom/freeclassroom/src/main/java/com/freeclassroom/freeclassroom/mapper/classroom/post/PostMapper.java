package com.freeclassroom.freeclassroom.mapper.classroom.post;

import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.PostResponse;
import com.freeclassroom.freeclassroom.entity.classroom.post.NoticeEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.PostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toResponseForClassDetail(PostEntity entity);
}
