package com.kochetkov.newpalette.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class SecurityHelper {

    public static String getLoggedUserName() {
        UserDetails securityUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser.getUsername();
    }

}
