package com.freeclassroom.freeclassroom.entity.user;

import com.freeclassroom.freeclassroom.entity.account.AccountEntity;
import com.freeclassroom.freeclassroom.entity.classroom.MemberShipEntity;
import jakarta.persistence.*;
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
@Table(name = "student")
public class StudentEntity extends UserEntity {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<MemberShipEntity> memberShip;

    @OneToOne
    @JoinColumn(name = "account_id")
    AccountEntity account;
}
