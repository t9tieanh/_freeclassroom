package com.freeclassroom.freeclassroom.service.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.SectionMapper;
import com.freeclassroom.freeclassroom.repository.SectionRepository;
import com.freeclassroom.freeclassroom.repository.classroom.ClassRoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SectionService {
    SectionRepository sectionRepository;
    ClassRoomRepository classRoomRepository;

    SectionMapper sectionMapper;

    public SectionCreationResponse addSection (SectionCreationRequest sectionCreationRequest) {
        ClassRoomEntity classRoomEntity = classRoomRepository.
                                    findById(sectionCreationRequest.getClassRoomId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        SectionEntity sectionEntity = sectionMapper.toEntity(sectionCreationRequest);
        sectionEntity.setClassRoom(classRoomEntity);

        return sectionMapper.toResponse(sectionRepository.save(sectionEntity));
    }



}
