package com.sayan.UrlShortner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDetailsDto {
    private String username;
    private String email;
}
