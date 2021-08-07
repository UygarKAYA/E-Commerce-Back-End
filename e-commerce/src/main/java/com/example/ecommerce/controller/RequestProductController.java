package com.example.ecommerce.controller;

import com.example.ecommerce.model.RequestProduct;
import com.example.ecommerce.service.RequestProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/requestProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestProductController
{
    private final RequestProductService requestProductService;

    @GetMapping("/allRequestProducts")
    public List<RequestProduct> fetchAllRequestProducts() {
        return requestProductService.getAllRequestProduct();
    }

    @GetMapping("allRequestProductsByID/{ID}")
    public Optional<RequestProduct> fetchAllRequestProductsByID(@PathVariable String ID) {
        return requestProductService.getAllRequestProductByID(ID);
    }

    @PostMapping("/addRequestProducts")
    public void createRequestProducts(@RequestBody RequestProduct requestProduct) {
        requestProductService.createNewRequestProducts(requestProduct);
    }
    
    @PutMapping("/updateRequestProducts/{ID}")
    public RequestProduct updateRequestProducts(@PathVariable("ID") String ID, @RequestBody RequestProduct requestProduct) {
        return requestProductService.updateExistRequestProducts(ID, requestProduct);
    }

    @DeleteMapping("/deletePurchasedProducts/{ID}")
    public void deleteRequestProducts(@PathVariable("ID") String ID) {
        requestProductService.deleteExistRequestProducts(ID);
    }
}
