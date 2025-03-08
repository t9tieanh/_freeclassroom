package com.freeclassroom.freeclassroom.service.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.PostResponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.PostEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.classroom.SectionMapper;
import com.freeclassroom.freeclassroom.mapper.classroom.post.PostMapper;
import com.freeclassroom.freeclassroom.repository.SectionRepository;
import com.freeclassroom.freeclassroom.repository.classroom.ClassRoomRepository;
import com.freeclassroom.freeclassroom.repository.classroom.post.PostRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SectionService {
    SectionRepository sectionRepository;
    ClassRoomRepository classRoomRepository;
    PostRepository postRepository;

    SectionMapper sectionMapper;
    PostMapper postMapper;

    public SectionCreationResponse addSection (SectionCreationRequest sectionCreationRequest) {
        ClassRoomEntity classRoomEntity = classRoomRepository.
                                    findById(sectionCreationRequest.getClassRoomId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        SectionEntity sectionEntity = sectionMapper.toEntity(sectionCreationRequest);
        sectionEntity.setClassRoom(classRoomEntity);

        return sectionMapper.toResponse(sectionRepository.save(sectionEntity));
    }

    public List<PostResponse> getPosts (String id) {

        List <PostEntity> postEntities = postRepository.findBySection_Id(id);

        return postEntities.stream().map(
                postEntity -> postMapper.toResponseForClassDetail(postEntity)
        ).collect(Collectors.toList());
    }



}
