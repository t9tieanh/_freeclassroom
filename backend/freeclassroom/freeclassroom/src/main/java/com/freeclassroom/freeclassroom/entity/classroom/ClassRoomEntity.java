package com.freeclassroom.freeclassroom.entity.classroom;

import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ClassRoomEntity extends AbstractEntity {
    String name;
    String coverImage;
    String unit;
    String code;
    String detail;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    TeacherEntity teacher;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<MemberShipEntity> memberShips;
}
