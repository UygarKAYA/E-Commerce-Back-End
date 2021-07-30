package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user)
    {
        userRepository.findUserByEmail(user.getEmail()).ifPresentOrElse(
                student -> {
                    System.out.println("Name: " + user.getName() + ", " + "E-Mail: " + user.getEmail() + " is already exist");
                }, () -> {
                    user.setDateTime(LocalDateTime.now());
                    userRepository.insert(user);
                    // System.out.println("Name: " + user.getName() + ", " + "E-Mail: " + user.getEmail() + " is added");
                }
        );
    }
}
