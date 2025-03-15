package com.kochetkov.newpalette.service;

import com.kochetkov.newpalette.entity.User;
import com.kochetkov.newpalette.enums.Role;
import com.kochetkov.newpalette.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public void testCreate() {
        User user = new User();
        user.setName("пользователь 3");
        user.setPassword("password");
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
