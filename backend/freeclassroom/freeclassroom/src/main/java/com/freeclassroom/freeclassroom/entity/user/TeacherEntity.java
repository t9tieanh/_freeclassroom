package com.freeclassroom.freeclassroom.entity.user;

import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherEntity extends UserEntity {
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    List<ClassRoomEntity> classRooms;
}