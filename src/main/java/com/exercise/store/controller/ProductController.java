package com.exercise.store.controller;

import com.exercise.store.bean.Product;
import com.exercise.store.bean.Response;
import com.exercise.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Response<List<Product>> allProducts() {

        Response<List<Product>> response = new Response<>();
        response.setStatusDescription("Success");
        response.setStatusCode("00");
        response.setResponse(productService.getProducts());
        return response;
    }

    @PostMapping(value = "/products")
    public Response<Product> addProduct(@RequestBody Product newProduct) {

        Response<Product> response = new Response<>();
        response.setStatusDescription("Success");
        response.setStatusCode("00");
        response.setResponse(productService.addProduct(newProduct));
        return response;
    }

    @GetMapping("/products/{id}")
    public Response<Product> getProduct(@PathVariable Long id) throws Exception {

        Response<Product> response = new Response<>();
        response.setStatusDescription("Success");
        response.setStatusCode("00");
        response.setResponse(productService.getProduct(id));

        return response;
    }

    @PutMapping("/products")
    public Response<String> updateProduct(@RequestBody Product newProduct) throws Exception {

        Response<String> response = new Response<>();
        response.setStatusDescription("Success");
        response.setStatusCode("00");
        productService.updateProduct(newProduct);
        return response;
    }

    @DeleteMapping("/products/{id}")
    public Response<String> deleteProduct(@PathVariable Long id) throws Exception {

        Response<String> response = new Response<>();
        response.setStatusDescription("Success");
        response.setStatusCode("00");
        productService.deleteProduct(id);
        return response;
    }

}


