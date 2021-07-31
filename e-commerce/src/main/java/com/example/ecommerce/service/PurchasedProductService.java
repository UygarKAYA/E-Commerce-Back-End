package com.example.ecommerce.service;

import com.example.ecommerce.model.PurchasedProducts;
import com.example.ecommerce.repository.PurchasedProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchasedProductService
{
    private final PurchasedProductRepository purchasedProductRepository;

    public List<PurchasedProducts> getAllPurchasedProducts() {
        return purchasedProductRepository.findAll();
    }

    public void createNewPurchasedProducts(@RequestBody PurchasedProducts purchasedProducts)
    {
        purchasedProductRepository.findUserByEmail(purchasedProducts.getEmail()).ifPresentOrElse(
                purchasedProductss -> {
                    System.out.println("E-mail: " + purchasedProducts.getEmail() + " is already exist");
                }, () -> {
                    purchasedProducts.setDateTime(LocalDateTime.now());
                    purchasedProductRepository.insert(purchasedProducts);
                    // System.out.println("E-mail: " + purchasedProducts.getEmail() + " is added");
                }
        );
    }
}
