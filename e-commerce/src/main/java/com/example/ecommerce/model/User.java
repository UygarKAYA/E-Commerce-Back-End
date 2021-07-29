package com.example.ecommerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
@Document(collection = "users")
public class User
{
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;
    private String username;
    private String password;
    private LocalDateTime dateTime;

    public User(String name, String surname, String email, String username, String password, LocalDateTime dateTime) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateTime = dateTime;
    }
}
