package com.freeclassroom.freeclassroom.dto.request.classroom.post;

import com.freeclassroom.freeclassroom.enums.FileTypeEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExerciseCreationRequest {
    String title;
    String content;
    String sectionId;

    LocalDate beginDate;
    LocalDate endDate;
    MultipartFile file;
}
