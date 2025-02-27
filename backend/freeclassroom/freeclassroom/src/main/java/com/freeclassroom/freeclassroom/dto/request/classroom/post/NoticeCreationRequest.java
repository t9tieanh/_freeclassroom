package com.freeclassroom.freeclassroom.dto.request.classroom.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoticeCreationRequest {
    String title;
    String content;
    String sectionId;
}
