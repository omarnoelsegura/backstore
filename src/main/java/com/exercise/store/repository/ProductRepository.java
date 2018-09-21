package com.exercise.store.repository;

import com.exercise.store.bean.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getProducts();

    Optional<Product> getProduct(Long code);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long code);

}
