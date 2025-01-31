package com.sayan.UrlShortner.services;

import com.sayan.UrlShortner.dto.JwtResponseDto;
import com.sayan.UrlShortner.dto.LoginRequest;
import com.sayan.UrlShortner.dto.RegisterRequest;
import com.sayan.UrlShortner.entities.CustomUserDetails;
import com.sayan.UrlShortner.entities.Users;
import com.sayan.UrlShortner.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;

    @Override
    public Users registerUser(RegisterRequest user) {
        Users users = new Users();
        users.setEmail(user.getEmail());
        users.setPassword(passwordEncoder.encode(user.getPassword()));
        users.setUsername(user.getUsername());
        return userRepository.save(users);
    }

    @Override
    public JwtResponseDto loginUser(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userDetails);
        return new JwtResponseDto(jwtToken);

    }

    @Override
    public Users findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
