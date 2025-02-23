package com.freeclassroom.freeclassroom.dto.response;

import com.freeclassroom.freeclassroom.entity.account.EnumRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    String accessToken;
    String username;
    String email;
    EnumRole role;
    boolean valid;
}
