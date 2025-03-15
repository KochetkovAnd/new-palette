package com.kochetkov.newpalette.security;

import com.kochetkov.newpalette.enums.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private Role role;
}
