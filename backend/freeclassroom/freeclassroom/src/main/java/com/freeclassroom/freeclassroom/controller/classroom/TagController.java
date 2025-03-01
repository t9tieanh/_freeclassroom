package com.freeclassroom.freeclassroom.controller.classroom;

import com.freeclassroom.freeclassroom.dto.request.classroom.SectionCreationRequest;
import com.freeclassroom.freeclassroom.dto.request.classroom.TagCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.SectionCreationResponse;
import com.freeclassroom.freeclassroom.dto.response.classroom.TagReponse;
import com.freeclassroom.freeclassroom.service.classroom.TagService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagController {

    TagService tagService;

    @PostMapping(consumes = "multipart/form-data")
    ApiResponse<TagReponse> addSection (@ModelAttribute TagCreationRequest request) throws IOException {
        TagReponse response = tagService.addTag(request);

        return ApiResponse.<TagReponse>builder()
                .message("create a successful tag !")
                .code(200)
                .result(response)
                .build();
    }
}
