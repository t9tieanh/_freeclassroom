package com.freeclassroom.freeclassroom.service.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.TagCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.TagReponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.TagEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.TagMapper;
import com.freeclassroom.freeclassroom.repository.classroom.ClassRoomRepository;
import com.freeclassroom.freeclassroom.repository.classroom.TagRepository;
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagService {
    TagRepository tagRepository;
    ClassRoomRepository classRoomRepository;
    FileStorageService fileStorageService;

    TagMapper tagMapper;

    public TagReponse addTag (TagCreationRequest request) throws IOException {
        List<ClassRoomEntity> classRoomEntities = new ArrayList<>();

        if (request.getClassroomIds() != null)
            request.getClassroomIds()
                .forEach(id -> {
                    classRoomEntities.add(classRoomRepository.findById(id).orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND)));
                });

        request.setIconUrl(
                fileStorageService.storeImage(request.getTagImage())
        );

        TagEntity tagEntity = tagMapper.toTagEntity(request);
        tagEntity.setClassrooms(classRoomEntities);

        return tagMapper.toTagReponse(tagRepository.save(tagEntity));
    }


}
