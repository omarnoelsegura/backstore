package com.exercise.store.service;

import com.exercise.store.bean.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Long code) throws Exception;

    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long code);

}
