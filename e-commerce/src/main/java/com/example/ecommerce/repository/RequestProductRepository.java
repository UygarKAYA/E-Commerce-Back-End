package com.example.ecommerce.repository;

import com.example.ecommerce.model.RequestProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestProductRepository extends MongoRepository<RequestProduct, String> {
    Optional<RequestProduct> findRequestProductByProductName(String productName);
}
