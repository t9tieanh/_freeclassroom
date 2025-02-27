package com.freeclassroom.freeclassroom.entity.classroom;

import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import lombok.experimental.SuperBuilder;
import org.hibernate.engine.internal.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "classroom")
public class ClassRoomEntity extends AbstractEntity {
    String name;
    String unit;
    String code;
    String detail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    TeacherEntity teacher;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<MemberShipEntity> memberShips;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    List <SectionEntity> sections;

    @ManyToMany(mappedBy = "classrooms")
    List <TagEntity> tags;
}
