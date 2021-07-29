package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }
