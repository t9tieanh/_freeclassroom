package com.freeclassroom.freeclassroom.dto.response.classroom.classdetail;

import com.freeclassroom.freeclassroom.enums.PostIconEnum;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    String id;
    String title;
    String content;
    LocalDate createDate;
    PostIconEnum postIcon;
}
