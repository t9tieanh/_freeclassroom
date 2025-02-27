package com.freeclassroom.freeclassroom.dto.request.classroom;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SectionCreationRequest {
    String title;
    String content;
    String classRoomId;
}
