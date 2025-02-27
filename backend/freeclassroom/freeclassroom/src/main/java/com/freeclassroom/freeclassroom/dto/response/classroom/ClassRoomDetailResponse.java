package com.freeclassroom.freeclassroom.dto.response.classroom;

import com.freeclassroom.freeclassroom.dto.response.classroom.classdetail.SectionResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassRoomDetailResponse {
    String name;
    String unit;
    String code;
    String detail;
    List<SectionResponse> sections;
}
