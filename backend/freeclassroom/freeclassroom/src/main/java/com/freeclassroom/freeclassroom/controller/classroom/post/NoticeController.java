package com.freeclassroom.freeclassroom.controller.classroom.post;


import com.freeclassroom.freeclassroom.dto.request.classroom.post.NoticeCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.NoticeCreationResponse;
import com.freeclassroom.freeclassroom.service.classroom.post.NoticeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NoticeController {

    NoticeService noticeService;

    @PostMapping
    ApiResponse<NoticeCreationResponse> addNotice(@RequestBody NoticeCreationRequest request) {
        NoticeCreationResponse response = noticeService.addNotice(request);

        return ApiResponse.<NoticeCreationResponse>builder()
                .message("create a successful notice !")
                .code(200)
                .result(response)
                .build();
    }
}
