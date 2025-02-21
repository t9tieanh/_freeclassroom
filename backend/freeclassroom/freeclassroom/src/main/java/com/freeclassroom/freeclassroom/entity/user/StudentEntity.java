package com.freeclassroom.freeclassroom.entity.user;

import com.freeclassroom.freeclassroom.entity.classroom.MemberShipEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class StudentEntity extends UserEntity {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<MemberShipEntity> memberShip;
}
