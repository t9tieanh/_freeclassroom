package com.freeclassroom.freeclassroom.service.classroom;

import com.freeclassroom.freeclassroom.dto.request.ClassRoomCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ClassRoomCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.ClassRoomDetailResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.TagReponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.PostResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.SectionResponse;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.PostEntity;
import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import com.freeclassroom.freeclassroom.exception.CustomExeption;
import com.freeclassroom.freeclassroom.exception.ErrorCode;
import com.freeclassroom.freeclassroom.mapper.ClassRoomMapper;
import com.freeclassroom.freeclassroom.mapper.TeacherMapper;
import com.freeclassroom.freeclassroom.mapper.classroom.SectionMapper;
import com.freeclassroom.freeclassroom.mapper.classroom.TagMapper;
import com.freeclassroom.freeclassroom.mapper.classroom.post.PostMapper;
import com.freeclassroom.freeclassroom.repository.TeacherRepository;
import com.freeclassroom.freeclassroom.repository.classroom.ClassRoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ClassRoomService {
    ClassRoomRepository classRoomRepository;
    TeacherRepository teacherRepository;

    ClassRoomMapper classRoomMapper;
    SectionMapper sectionMapper;
    PostMapper postMapper;
    TeacherMapper teacherMapper;
    TagMapper tagMapper;


    public ClassRoomCreationResponse addClassRoom(ClassRoomCreationRequest request) throws IOException {

        TeacherEntity teacherEntity = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_EXISTED));

        ClassRoomEntity classRoomEntity = classRoomMapper.toClassRoomEntity(request);
        classRoomEntity.setTeacher(teacherEntity);

        return classRoomMapper.toClassRoomCreationResponse(
                classRoomRepository.save(classRoomEntity)
        );
    }

    public Page<ClassRoomCreationResponse> getClassRoom(String teacherUsername, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);

        Page<ClassRoomEntity> classRooms = classRoomRepository.findByUsernameTeacher
                (teacherUsername, pageable);

        return classRooms.map(classRoomMapper::toClassRoomCreationResponse);
    }

    public ClassRoomDetailResponse getClassRoomDetail (String classRoomId) {
        ClassRoomEntity classRoomEntity = classRoomRepository.findById(classRoomId)
                .orElseThrow(() -> new CustomExeption(ErrorCode.USER_NOT_FOUND));

        ClassRoomDetailResponse classRoom = classRoomMapper.toResponseClassRoomDetail(classRoomEntity);

        // lấy teacher
        classRoom.setTeacher(teacherMapper.toTeacherResponse(classRoomEntity.getTeacher()));

        // lấy section
        List<SectionEntity> sectionEntities = classRoomEntity.getSections();

//        List<SectionResponse> sections = new ArrayList<>();
//
//        sectionEntities.stream().forEach(
//                section -> {
//                    SectionResponse sectionResponse = sectionMapper.toResponseForClassDetail(section);
//                    sections.add(sectionResponse);
//
//                    List<PostResponse> posts = section.getPosts().stream().map(
//                            postEntity -> postMapper.toResponseForClassDetail(postEntity)
//                    ).collect(Collectors.toList());
//
//                    sectionResponse.setPosts(posts);
//                }
//        );
        classRoom.setSections(sectionEntities.stream().map(
                sectionEntity -> sectionMapper.toResponseForClassDetail(sectionEntity)
        ).collect(Collectors.toList()));

        // lấy tag
        classRoom.setTag(classRoomEntity.getTags().stream().map(tagEntity ->
            tagMapper.toTagReponse(tagEntity)
        ).collect(Collectors.toList()));

        return classRoom;
    }





}
