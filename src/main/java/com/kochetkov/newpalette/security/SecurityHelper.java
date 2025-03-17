package com.kochetkov.newpalette.security;

import com.kochetkov.newpalette.entity.User;
import com.kochetkov.newpalette.exception.NotFoundException;
import com.kochetkov.newpalette.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



public class SecurityHelper {
    public static String getLoggedUserName() {
        UserDetails securityUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser.getUsername();
    }

}
