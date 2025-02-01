package com.sayan.UrlShortner.services;


import com.sayan.UrlShortner.dto.JwtResponseDto;
import com.sayan.UrlShortner.dto.LoginRequest;
import com.sayan.UrlShortner.dto.RegisterRequest;
import com.sayan.UrlShortner.dto.UserDetailsDto;
import com.sayan.UrlShortner.entities.Users;

public interface UserService {
     Users registerUser(RegisterRequest user);

    JwtResponseDto loginUser(LoginRequest request);

    Users findByUsername(String name);

    UserDetailsDto getUserDetails(String username);
}
