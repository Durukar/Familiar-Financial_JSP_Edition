package com.fafi.controllers;

import com.fafi.exception.UnsupportedParameterException;
import com.fafi.models.User;
import com.fafi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping( "/create")
    public User create(@RequestBody User userData) {

        if (userData.getUsername() == null) {
            throw new UnsupportedParameterException("Please provide a user data");
        }
        return userService.save(userData);
    }
}
