package com.example.ecommerce.repository;

import com.example.ecommerce.model.PurchasedProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchasedProductRepository extends MongoRepository<PurchasedProducts, String> {
    Optional<PurchasedProducts> findPurchasedProductByEmail(String email);
}
