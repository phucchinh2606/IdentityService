package com.chinhdo.identity_service.controller;

import com.chinhdo.identity_service.dto.request.ApiResponse;
import com.chinhdo.identity_service.dto.request.AuthenticationRequest;
import com.chinhdo.identity_service.dto.request.IntrospectRequest;
import com.chinhdo.identity_service.dto.request.LogoutRequest;
import com.chinhdo.identity_service.dto.response.AuthenticationResponse;
import com.chinhdo.identity_service.dto.response.IntrospectResponse;
import com.chinhdo.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        //map body vao request
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(1000)
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        //map body vao request
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request)
            throws ParseException, JOSEException {
        //map body vao request
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .build();
    }
}
