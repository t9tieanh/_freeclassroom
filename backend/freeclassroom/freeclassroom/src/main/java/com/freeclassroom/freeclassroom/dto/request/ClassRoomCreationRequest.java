package com.freeclassroom.freeclassroom.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassRoomCreationRequest {
    String name;
    String unit;
    String code;
    String detail;
    String teacherId;
}
