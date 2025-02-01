package com.sayan.UrlShortner.controllers;

import com.sayan.UrlShortner.dto.LoginRequest;
import com.sayan.UrlShortner.dto.RegisterRequest;
import com.sayan.UrlShortner.services.JwtService;
import com.sayan.UrlShortner.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> verify(@RequestBody LoginRequest request){
       return ResponseEntity.ok(userService.loginUser(request));

    }

    @GetMapping("/getDetails")
    public ResponseEntity<?> getDetails(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.substring(7);
        return ResponseEntity.ok(userService.getUserDetails(token));
    }
}
