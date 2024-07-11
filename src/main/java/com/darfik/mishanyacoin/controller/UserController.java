package com.darfik.mishanyacoin.controller;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfoResponse;
import com.darfik.mishanyacoin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserInfoResponse getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    public void createUser(@RequestBody RegistrationRequest registrationRequest) {
        userService.createUser(registrationRequest);
    }

}
