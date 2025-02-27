package com.freeclassroom.freeclassroom.mapper.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.SectionResponse;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionEntity toEntity(SectionCreationRequest section);
    SectionCreationResponse toResponse(SectionEntity section);
    SectionResponse toResponseForClassDetail(SectionEntity section);
}
