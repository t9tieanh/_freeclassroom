package com.freeclassroom.freeclassroom.service.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.NoticeCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.NoticeCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.NoticeEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.PostEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.post.NoticeMapper;
import com.freeclassroom.freeclassroom.repository.SectionRepository;
import com.freeclassroom.freeclassroom.repository.classroom.post.NoticeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class NoticeService {
    NoticeRepository noticeRepository;
    SectionRepository sectionRepository;

    NoticeMapper noticeMapper;

    public NoticeCreationResponse addNotice(NoticeCreationRequest request) {
        SectionEntity sectionEntity = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        NoticeEntity noticeEntity = noticeMapper.toEntity(request);
        noticeEntity.setSection(sectionEntity);
        sectionEntity.getPosts().add(noticeEntity);

         sectionRepository.save(sectionEntity);
         return null;
    }



}
