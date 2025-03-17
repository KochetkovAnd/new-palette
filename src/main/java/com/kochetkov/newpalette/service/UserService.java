package com.kochetkov.newpalette.service;

import com.kochetkov.newpalette.dto.UserDto;
import com.kochetkov.newpalette.entity.User;
import com.kochetkov.newpalette.exception.NotFoundException;
import com.kochetkov.newpalette.repository.UserRepository;
import com.kochetkov.newpalette.repository.nativeRepository.NativeRepository;
import com.kochetkov.newpalette.security.SecurityHelper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    NativeRepository nativeRepository;

    public void testCreate() {
        List<UserDto> users = nativeRepository.get("""
                SELECT
                    id as "id",
                    name as "name"
                from "user" where id = 1
                """,
                UserDto.class);
        int n = 5;
    }

    public User getLoggedUser() {
        return userRepository.findByName(SecurityHelper.getLoggedUserName()).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
