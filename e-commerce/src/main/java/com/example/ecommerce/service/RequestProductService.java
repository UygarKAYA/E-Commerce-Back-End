package com.example.ecommerce.service;

import com.example.ecommerce.model.RequestProduct;
import com.example.ecommerce.repository.RequestProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestProductService
{
    private final RequestProductRepository requestProductRepository;

    public List<RequestProduct> getAllRequestProduct() {
        return requestProductRepository.findAll();
    }

    public Optional<RequestProduct> getAllRequestProductByID(String ID) {
        return requestProductRepository.findById(ID);
    }

    public void createNewRequestProducts(RequestProduct requestProduct) {
        requestProductRepository.findRequestProductByProductName(requestProduct.getProductName()).ifPresentOrElse(
                requestProductt -> {
                    System.out.println("Request Product: " + requestProduct.getProductName() + " is already exist");
                }, () -> {
                    requestProduct.setLocalDateTime(LocalDateTime.now());
                    requestProductRepository.insert(requestProduct);
                    // System.out.println("Request Product: " + requestProduct.getProductName() + " is added");
                }
        );
    }

    public RequestProduct updateExistRequestProducts(String ID, RequestProduct requestProduct) {
        requestProduct.setID(ID);
        requestProduct.setLocalDateTime(LocalDateTime.now());
        return requestProductRepository.save(requestProduct);
    }

    public void deleteExistRequestProducts(String ID) {
        requestProductRepository.deleteById(ID);
    }
}
