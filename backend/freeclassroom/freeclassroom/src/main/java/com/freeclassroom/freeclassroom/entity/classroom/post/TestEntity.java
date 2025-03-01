package com.freeclassroom.freeclassroom.entity.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.enums.AllowTestTimeEnum;
import com.freeclassroom.freeclassroom.enums.PostIconEnum;
import com.freeclassroom.freeclassroom.enums.ScoringMethodEnum;
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
@Table(name = "test")
public class TestEntity extends PostEntity {
    LocalDate beginDate;
    LocalDate endDate;
    String password;
    AllowTestTimeEnum allowTestTime;
    ScoringMethodEnum scoringMethod;

    @PrePersist
    public void prePersist() {
        if (getPostIcon() == null) {
            setPostIcon(PostIconEnum.TEST);
        }
    }
}
