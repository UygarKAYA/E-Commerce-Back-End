package com.example.ecommerce.controller;

import com.example.ecommerce.model.PurchasedProducts;
import com.example.ecommerce.repository.PurchasedProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/purchasedProducts")
public class PurchasedProductsController
{
    private final PurchasedProductRepository purchasedProductRepository;

    @GetMapping("/allPurchasedProducts")
    public List<PurchasedProducts> fetchAllPurchasedProducts() {
        return purchasedProductRepository.findAll();
    }

    @PostMapping("/addPurchasedProducts")
    public void createPurchasedProducts(@RequestBody PurchasedProducts purchasedProducts)
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
