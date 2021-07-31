package com.example.ecommerce.service;

import com.example.ecommerce.model.PurchasedProducts;
import com.example.ecommerce.repository.PurchasedProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void createNewPurchasedProducts(PurchasedProducts purchasedProducts) {
        purchasedProductRepository.findPurchasedProductByEmail(purchasedProducts.getEmail()).ifPresentOrElse(
                purchasedProductss -> {
                    System.out.println("E-mail: " + purchasedProducts.getEmail() + " is already exist");
                }, () -> {
                    purchasedProducts.setDateTime(LocalDateTime.now());
                    purchasedProductRepository.insert(purchasedProducts);
                    // System.out.println("E-mail: " + purchasedProducts.getEmail() + " is added");
                }
        );
    }

    public PurchasedProducts updateExistPurchasedProducts(String ID, PurchasedProducts purchasedProducts) {
        purchasedProducts.setID(ID);
        purchasedProducts.setDateTime(LocalDateTime.now());
        return purchasedProductRepository.save(purchasedProducts);
    }

    public void deleteExistPurchasedProducts(String ID) {
        purchasedProductRepository.deleteById(ID);
    }
}
