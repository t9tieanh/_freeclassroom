package com.freeclassroom.freeclassroom.dto.request;

import com.freeclassroom.freeclassroom.entity.account.EnumAccountStatus;
import com.freeclassroom.freeclassroom.entity.account.EnumRole;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActiveAccountRequest {
    String email; // cần để tìm account
    String image;
    String name;
    String phone;

    String username;
    String password;
    String ggId;
    EnumRole role;
    EnumAccountStatus status;

    MultipartFile imageFile;
}
