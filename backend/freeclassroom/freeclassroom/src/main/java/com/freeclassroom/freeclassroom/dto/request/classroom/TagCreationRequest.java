package com.freeclassroom.freeclassroom.dto.request.classroom;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagCreationRequest {
    String name;
    String iconUrl;

    List<String> classroomIds;
    MultipartFile tagImage;
}
