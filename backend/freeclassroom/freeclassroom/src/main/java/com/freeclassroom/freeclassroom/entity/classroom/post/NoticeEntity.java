package com.freeclassroom.freeclassroom.entity.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;



@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@Table(name = "notice")
public class NoticeEntity extends PostEntity {
    @ManyToOne
    @JoinColumn(name = "section_id")
    SectionEntity section;
}
