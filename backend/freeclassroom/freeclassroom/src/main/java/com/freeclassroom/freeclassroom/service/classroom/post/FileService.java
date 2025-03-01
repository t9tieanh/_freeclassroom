package com.freeclassroom.freeclassroom.service.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.FileCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.post.NoticeCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.FileCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.NoticeCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.FileEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.NoticeEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.post.FileMapper;
import com.freeclassroom.freeclassroom.mapper.classroom.post.NoticeMapper;
import com.freeclassroom.freeclassroom.repository.SectionRepository;
import com.freeclassroom.freeclassroom.repository.classroom.post.FileRepository;
import com.freeclassroom.freeclassroom.repository.classroom.post.NoticeRepository;
import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class FileService {
    FileRepository fileRepository;
    SectionRepository sectionRepository;
    FileStorageService fileStorageService;

    FileMapper fileMapper;

    public FileCreationResponse addFile(FileCreationRequest request) throws IOException {
        SectionEntity sectionEntity = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        FileEntity fileEntity = fileMapper.toEntity(request);
        fileEntity.setSection(sectionEntity);
        sectionEntity.getPosts().add(fileEntity);

        // tiến hành lưu file
        fileEntity.setFileUrl(
                fileStorageService.storeFileAuto(request.getFile())
        );

        return fileMapper.toResponse(fileRepository.save(fileEntity));
    }

}
