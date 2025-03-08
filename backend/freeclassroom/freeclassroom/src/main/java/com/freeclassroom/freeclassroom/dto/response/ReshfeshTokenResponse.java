package com.freeclassroom.freeclassroom.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReshfeshTokenResponse {
    String accessToken;
    String refreshToken;
}
