package com.exercise.store;

import com.exercise.store.bean.Product;
import com.exercise.store.exception.ProductNotFoundException;
import com.exercise.store.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenFindProducts_thenReturnListOfProducts() {
        // given

        // when
        List<Product> products = productService.getProducts();

        // then
        assertThat(products, is(notNullValue()));
    }

    @Test
    public void whenAddProduct_thenSaveProduct() throws Exception {
        // given
        Product product = new Product();
        product.setCode(4L);
        product.setName("balde spiderman");
        product.setDescription("balde spiderman");
        product.setStock(50);

        // when
        Product newProduct = productService.addProduct(product);

        // then
        assertThat(newProduct, is(notNullValue()));

        assertEquals(product.getCode(), (productService.getProduct(newProduct.getCode()).getCode()));
    }


    @Test(expected = ProductNotFoundException.class)
    public void whenDeleteProduct_thenThrowsNotFoundException() throws Exception {
        // given
        Product product = productService.getProduct(1L);

        // when
        productService.deleteProduct(product.getCode());

        // then
        Product notFoundProduct = productService.getProduct(1L);


    }

    @Test
    public void whenUpdateStock_thenProductUpdated() throws Exception {
        // given
        Product product = productService.getProduct(2L);

        // when
        product.setStock(10);
        productService.updateProduct(product);

        // then
        Product productUpdated = productService.getProduct(2L);

        assertThat(productUpdated, is(notNullValue()));

        assertTrue("Se actualizó el stock",(productUpdated.getStock() == 10));
    }

}
