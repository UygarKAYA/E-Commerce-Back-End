package com.example.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "purchasedProducts")
public class PurchasedProducts
{
    @Id
    private String ID;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String address;
    private DetailedAddress detailedAddress;
    private String productName;
    private String productPrice;
    private int productQuantity;
    private LocalDateTime dateTime;

    public PurchasedProducts(String firstName, String lastName, String email, String address, DetailedAddress detailedAddress, String productName, String productPrice, int productQuantity, LocalDateTime dateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.dateTime = dateTime;
    }
}
