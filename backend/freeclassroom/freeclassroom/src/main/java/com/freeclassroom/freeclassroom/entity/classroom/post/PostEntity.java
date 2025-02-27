package com.freeclassroom.freeclassroom.entity.classroom.post;

import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.enums.PostIconEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PostEntity extends AbstractEntity {
    String title;
    String content;

    @CreatedDate
    @Column(updatable = false)
    LocalDate createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    SectionEntity section;
}
