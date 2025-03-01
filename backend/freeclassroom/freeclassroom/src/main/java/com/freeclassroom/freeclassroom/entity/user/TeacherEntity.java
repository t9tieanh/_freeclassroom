package com.freeclassroom.freeclassroom.entity.user;

import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import jakarta.persistence.*;
import jdk.jfr.Name;
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
@Table(name = "teacher")
public class TeacherEntity extends UserEntity {

    String description;
    String position;
    String email;

    @OneToMany(mappedBy = "teacher")
    List<ClassRoomEntity> classRooms;

    @OneToOne
    @JoinColumn(name = "account_id")
    AccountEntity account;
}