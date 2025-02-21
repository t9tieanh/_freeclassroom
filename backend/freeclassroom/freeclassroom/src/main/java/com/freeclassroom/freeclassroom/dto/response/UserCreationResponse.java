package com.freeclassroom.freeclassroom.dto.response;

import com.freeclassroom.freeclassroom.entity.account.EnumAccountStatus;
import com.freeclassroom.freeclassroom.entity.account.EnumRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationResponse {
    String email;
    String image;
    String name;
    String phone;

    String username;
    String ggId;
    EnumRole role;
    EnumAccountStatus status;
}
