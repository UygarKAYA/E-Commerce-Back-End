package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController
{
    private final UserRepository userRepository;

    @GetMapping("/allUsers")
    public List<User> fetchAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public void createUser(@RequestBody User user) {
        userRepository.findUserByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresentOrElse(
                users -> {
                    userRepository.findUserByUsername(user.getUsername()).ifPresent(
                            userss -> {
                                System.out.println("Username: " + user.getUsername() + " is already exist");
                            }
                    );
                    userRepository.findUserByEmail(user.getEmail()).ifPresent(
                            userss -> {
                                System.out.println("E-mail: " + user.getEmail() + " is already exist");
                            }
                    );
                    System.out.println();
                }, () -> {
                    user.setDateTime(LocalDateTime.now());
                    userRepository.insert(user);
                    // System.out.println("Username: " + user.getUsername() + " & " + "E-mail: " + user.getEmail() + " is added");
                }
        );
    }
}
