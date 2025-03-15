package com.kochetkov.newpalette.dto;

import com.kochetkov.newpalette.entity.User;
import com.kochetkov.newpalette.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String name;
    String password;
    Role role;

    public UserDto(User user) {
        BeanUtils.copyProperties(this, user);
    }
}
