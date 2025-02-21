package com.freeclassroom.freeclassroom.controller;

import com.freeclassroom.freeclassroom.dto.request.AuthenticationRequest;
import com.freeclassroom.freeclassroom.dto.request.UserCreationRequest;
import com.freeclassroom.freeclassroom.dto.response.ApiResponse;
import com.freeclassroom.freeclassroom.dto.response.AuthenticationResponse;
import com.freeclassroom.freeclassroom.dto.response.UserCreationResponse;
import com.freeclassroom.freeclassroom.service.auth.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping(value="sign-up", consumes = "multipart/form-data")
    public ApiResponse<UserCreationResponse> signUp(@ModelAttribute UserCreationRequest userCreationRequest) throws IOException {

        UserCreationResponse response = authenticationService.signUp(userCreationRequest);

        return ApiResponse.<UserCreationResponse>builder()
                .code(200)
                .message("Account has been created, please enter the OTP code sent to your email to activate account")
                .result(response)
                .build();
    }

    @PostMapping("login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws JOSEException {

        AuthenticationResponse response = authenticationService.authentication(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .result(response)
                .build();
    }

}
