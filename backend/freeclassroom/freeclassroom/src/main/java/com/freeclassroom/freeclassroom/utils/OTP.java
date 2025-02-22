package com.freeclassroom.freeclassroom.utils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OTP {

    String otp;

    public OTP() {
        generateOTP(4);
    }

    void generateOTP(int otpLength) {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }

        this.otp = otp.toString();
    }
}
