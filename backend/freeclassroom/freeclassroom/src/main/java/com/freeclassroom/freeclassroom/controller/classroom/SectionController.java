package com.freeclassroom.freeclassroom.controller.classroom;

import com.freeclassroom.freeclassroom.dto.request.ClassRoomCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.ClassRoomCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.service.classroom.ClassRoomService;
import com.freeclassroom.freeclassroom.service.classroom.SectionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/section")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SectionController {

    SectionService sectionService;

    @PostMapping
    ApiResponse<SectionCreationResponse> addSection (@RequestBody SectionCreationRequest request) throws IOException {
        SectionCreationResponse response = sectionService.addSection(request);

        return ApiResponse.<SectionCreationResponse>builder()
                .message("create a successful section !")
                .code(200)
                .result(response)
                .build();
    }
}
