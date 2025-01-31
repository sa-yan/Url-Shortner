package com.sayan.UrlShortner.services;

import com.sayan.UrlShortner.entities.CustomUserDetails;
import com.sayan.UrlShortner.entities.Users;
import com.sayan.UrlShortner.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(Objects.isNull(user)) {
            System.out.println("USERNAME NOT FOUND!");
            throw new UsernameNotFoundException("USERNAME NOT FOUND");
        }
        return new CustomUserDetails(user);
    }
}
