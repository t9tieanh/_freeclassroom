package com.freeclassroom.freeclassroom.mapper;

import com.freeclassroom.freeclassroom.dto.request.ClassRoomCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ClassRoomCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassRoomMapper {
    @Mapping(target = "coverImage", ignore = true)
    ClassRoomEntity toClassRoomEntity (ClassRoomCreationRequest request);
    ClassRoomCreationResponse toClassRoomCreationResponse (ClassRoomEntity classRoomEntity);
}
