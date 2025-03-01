package com.freeclassroom.freeclassroom.service.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.ExerciseCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.ExerciseCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.ExerciseEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.post.ExerciseMapper;
import com.freeclassroom.freeclassroom.repository.SectionRepository;
import com.freeclassroom.freeclassroom.repository.classroom.post.ExerciseRepository;
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;
    SectionRepository sectionRepository;
    FileStorageService fileStorageService;

    ExerciseMapper exerciseMapper;

    public ExerciseCreationResponse addExercise(ExerciseCreationRequest request) throws IOException {
        SectionEntity sectionEntity = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        ExerciseEntity exerciseEntity = exerciseMapper.toEntity(request);
        exerciseEntity.setSection(sectionEntity);
        sectionEntity.getPosts().add(exerciseEntity);

        // lưu file đính kèm
        if (request.getFile() != null) {
            exerciseEntity.setAttachedFileUrl(
                    fileStorageService.storeImage(request.getFile())
            );
        }

        return exerciseMapper.toResponse(exerciseRepository.save(exerciseEntity));
    }

}
