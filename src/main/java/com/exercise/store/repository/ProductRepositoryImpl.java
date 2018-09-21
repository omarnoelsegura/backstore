package com.exercise.store.repository;

import com.exercise.store.bean.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    List<Product> data = new ArrayList<Product>();

    @PostConstruct
    void populateData(){
        data.add(new Product(1L,"vaso","vaso hulk","https://http2.mlstatic.com/taza-hulk-avengers-D_Q_NP_966074-MPE27949996802_082018-R.webp",200));
        data.add(new Product(2L,"vaso","vaso spiderman","https://http2.mlstatic.com/vaso-de-spiderman-ultimate-de-marvel-D_NQ_NP_902973-MPE27239113231_042018-O.webp",200));
    }

    @Override
    public List<Product> getProducts() {
        return data;
    }

    @Override
    public Optional<Product> getProduct(Long code) {
        return data.stream().filter(product -> product.getCode()==code).findFirst();
    }

    @Override
    public void addProduct(Product product) {
        data.add(product);

    }

    @Override
    public void updateProduct(Product product) {
        List<Product> newProducts = data.stream().map(product1 -> product1.getCode()==product.getCode()?product:product1)
                .collect(Collectors.toList());
        data.clear();
        data.addAll(newProducts);
    }

    @Override
    public void deleteProduct(Long code) {
        Optional<Product> prod = data.stream().filter(product1 -> product1.getCode()==code).findFirst();
        if(prod.isPresent()){
            data.remove(prod.get());
        }
    }

}
