package com.freeclassroom.freeclassroom.entity.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.enums.FileTypeEnum;
import com.freeclassroom.freeclassroom.enums.PostIconEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "exercise")
public class ExerciseEntity extends PostEntity {
    LocalDate beginDate;
    LocalDate endDate;
    String attachedFileUrl;
    FileTypeEnum fileTypeEnum;

    @PrePersist
    public void prePersist() {
        if (getPostIcon() == null) { // Chỉ set nếu chưa có giá trị
            setPostIcon(PostIconEnum.EXERCISE);
        }
    }
}
