package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController
{
    private final UserService userService;

    @GetMapping("/allUsers")
    public List<User> fetchAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
