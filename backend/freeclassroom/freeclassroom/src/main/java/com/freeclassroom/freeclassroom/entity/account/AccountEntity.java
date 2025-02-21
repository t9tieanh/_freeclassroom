package com.freeclassroom.freeclassroom.entity.account;

import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class AccountEntity extends AbstractEntity {
    String username;
    String password;
    String email;
    String ggId;
    EnumRole role;
    EnumAccountStatus status;

    public AccountEntity() {
        super();
    }
}
