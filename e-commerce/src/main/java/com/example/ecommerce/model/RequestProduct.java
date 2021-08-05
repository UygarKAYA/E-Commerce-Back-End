package com.example.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "requestProducts")
public class RequestProduct
{
    @Id
    private String ID;
    private String productName;
    private String productPrice;
    private String productCategories;
    private String firstDescription;
    private String secondDescription;
    private String thirdDescription;
    private LocalDateTime localDateTime;

    public RequestProduct(String productName, String productPrice, String productCategories, String firstDescription,
                            String secondDescription, String thirdDescription, LocalDateTime localDateTime) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategories = productCategories;
        this.firstDescription = firstDescription;
        this.secondDescription = secondDescription;
        this.thirdDescription = thirdDescription;
        this.localDateTime = localDateTime;
    }
}
