package com.freeclassroom.freeclassroom.mapper.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.TagCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.TagReponse;
import com.freeclassroom.freeclassroom.entity.classroom.TagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagEntity toTagEntity(TagCreationRequest tag);
    TagReponse toTagReponse(TagEntity tag);
}
