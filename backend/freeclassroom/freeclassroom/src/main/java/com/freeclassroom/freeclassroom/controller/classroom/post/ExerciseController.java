package com.freeclassroom.freeclassroom.controller.classroom.post;

import com.freeclassroom.freeclassroom.dto.request.classroom.post.ExerciseCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.post.FileCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.ExerciseCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.post.FileCreationResponse;
import com.freeclassroom.freeclassroom.service.classroom.post.ExerciseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/excercise")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExerciseController {

    ExerciseService service;

    @PostMapping(consumes = "multipart/form-data")
    public ApiResponse<ExerciseCreationResponse> addFile(@ModelAttribute ExerciseCreationRequest request) throws IOException {

        ExerciseCreationResponse response = service.addExercise(request);

        return ApiResponse.<ExerciseCreationResponse>builder()
                .code(200)
                .message("create a successful excercise !")
                .result(response)
                .build();
    }

}
