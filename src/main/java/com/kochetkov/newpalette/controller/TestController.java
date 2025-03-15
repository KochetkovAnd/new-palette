package com.kochetkov.newpalette.controller;

import com.kochetkov.newpalette.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestController {

    UserService userService;

    @GetMapping
    public Boolean test() {
        userService.testCreate();
        return true;
    }

}
