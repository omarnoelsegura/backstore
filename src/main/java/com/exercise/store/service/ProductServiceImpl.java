package com.exercise.store.service;

import com.exercise.store.bean.Product;
import com.exercise.store.exception.ProductNotFoundException;
import com.exercise.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProduct(Long code) throws Exception{
        Optional<Product> product = productRepository.getProduct(code);

        if(product.isPresent()){
            return product.get();
        }else{
           throw new ProductNotFoundException("Producto no encontrado");
        }

    }

    @Override
    public Product addProduct(Product product) {
        productRepository.addProduct(product);
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long code) {
        productRepository.deleteProduct(code);
    }
}
