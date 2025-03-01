package com.freeclassroom.freeclassroom.dto.response.classroom;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagReponse {
    String name;
    String iconUrl;
}
