package com.freeclassroom.freeclassroom.dto.response.classroom.classdetail;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SectionResponse {
    String title;
    String content;
    LocalDate createDate;
    boolean emphasized;
    List<PostResponse> posts;
}
