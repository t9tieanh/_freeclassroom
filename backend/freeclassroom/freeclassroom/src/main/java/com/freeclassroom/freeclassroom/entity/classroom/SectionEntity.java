package com.freeclassroom.freeclassroom.entity.classroom;

import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import com.freeclassroom.freeclassroom.entity.classroom.post.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "section")
@EntityListeners(AuditingEntityListener.class)
public class SectionEntity extends AbstractEntity {
    String title;
    String content;
    boolean emphasized;


    @CreatedDate
    LocalDate createDate;



    @ManyToOne
    @JoinColumn(name = "classroom_id")
    ClassRoomEntity classRoom;

    @OneToMany(mappedBy = "section")
    List<PostEntity> posts;

}
