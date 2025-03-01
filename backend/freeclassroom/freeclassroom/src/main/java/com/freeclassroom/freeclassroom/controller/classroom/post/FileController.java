package com.freeclassroom.freeclassroom.controller.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.post.FileCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.FileCreationResponse;
import com.freeclassroom.freeclassroom.service.classroom.post.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file-class")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileController{
    FileService fileService;

    @PostMapping(consumes = "multipart/form-data")
    public ApiResponse<FileCreationResponse> addFile(@ModelAttribute FileCreationRequest request) throws IOException {

        FileCreationResponse response = fileService.addFile(request);

        return ApiResponse.<FileCreationResponse>builder()
                .code(200)
                .message("create a successful notice !")
                .result(response)
                .build();
    }
}
