package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void createNewUser(@RequestBody User user) {
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
