package com.example.monapplocation.service.security;

import com.example.monapplocation.model.dto.request.SignUpRequest;
import com.example.monapplocation.model.dto.request.SigninRequest;
import com.example.monapplocation.model.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
