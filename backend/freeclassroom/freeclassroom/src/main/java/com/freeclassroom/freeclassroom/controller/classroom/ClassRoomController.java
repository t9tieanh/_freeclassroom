package com.freeclassroom.freeclassroom.controller.classroom;

import com.freeclassroom.freeclassroom.dto.request.ClassRoomCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.ClassRoomCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.ClassRoomDetailResponse;
import com.freeclassroom.freeclassroom.service.classroom.ClassRoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassRoomController {
    ClassRoomService classRoomService;

    @PostMapping
    ApiResponse <ClassRoomCreationResponse> addClassRoom(@RequestBody ClassRoomCreationRequest classRoomCreationRequest) throws IOException {
        ClassRoomCreationResponse response = classRoomService.addClassRoom(classRoomCreationRequest);

        return ApiResponse.<ClassRoomCreationResponse>builder()
                .message("create a successful classroom !")
                .code(200)
                .result(response)
                .build();
    }

    @GetMapping
    public ApiResponse<Page<ClassRoomCreationResponse>> getAllClassRooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userNameTeacher = authentication.getName();

        // Gọi Service để lấy danh sách lớp học có phân trang
        Page<ClassRoomCreationResponse> response = classRoomService.getClassRoom(userNameTeacher, page, limit);

        return ApiResponse.<Page<ClassRoomCreationResponse>>builder()
                .message("Get your class successful!")
                .code(200)
                .result(response)
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<ClassRoomDetailResponse> getClassDetail(@PathVariable String id) {
        ClassRoomDetailResponse response = classRoomService.getClassRoomDetail(id);

        return ApiResponse.<ClassRoomDetailResponse>builder()
                .message("Get your class successful!")
                .code(200)
                .result(response)
                .build();
    }




}
