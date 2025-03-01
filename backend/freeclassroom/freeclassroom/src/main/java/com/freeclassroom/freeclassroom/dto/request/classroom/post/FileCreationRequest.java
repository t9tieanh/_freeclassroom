package com.freeclassroom.freeclassroom.dto.request.classroom.post;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileCreationRequest {
    String title;
    String content;
    String sectionId;
    MultipartFile file;
}
