package com.freeclassroom.freeclassroom.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    String token;
    boolean valid;
}
