package com.example.ecommerce.repository;

import com.example.ecommerce.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUsernameOrEmail(String username, String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}
