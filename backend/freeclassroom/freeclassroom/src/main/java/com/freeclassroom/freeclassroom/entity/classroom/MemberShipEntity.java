package com.freeclassroom.freeclassroom.entity.classroom;

import com.freeclassroom.freeclassroom.entity.user.StudentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "membership")
public class MemberShipEntity extends AbstractEntity {
    LocalDate joinDate;
    String role;

    LocalDate LastAccessTime;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    ClassRoomEntity classRoom;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentEntity student; ;
}
