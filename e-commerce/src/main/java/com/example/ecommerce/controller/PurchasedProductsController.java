package com.example.ecommerce.controller;

import com.example.ecommerce.model.PurchasedProducts;
import com.example.ecommerce.service.PurchasedProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/purchasedProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class PurchasedProductsController
{
    private final PurchasedProductService purchasedProductService;

    @GetMapping("/allPurchasedProducts")
    public List<PurchasedProducts> fetchAllPurchasedProducts() {
        return purchasedProductService.getAllPurchasedProducts();
    }

    @PostMapping("/addPurchasedProducts")
    public void createPurchasedProducts(@RequestBody PurchasedProducts purchasedProducts) {
        purchasedProductService.createNewPurchasedProducts(purchasedProducts);
    }

    @PutMapping("/updatePurchasedProducts/{ID}")
    public PurchasedProducts updatePurchasedProducts(@PathVariable("ID") String ID, @RequestBody PurchasedProducts purchasedProducts) {
        return purchasedProductService.updateExistPurchasedProducts(ID, purchasedProducts);
    }

    @DeleteMapping("/deletePurchasedProducts/{ID}")
    public void deletePurchasedProducts(@PathVariable("ID") String ID) {
        purchasedProductService.deleteExistPurchasedProducts(ID);
    }
}
