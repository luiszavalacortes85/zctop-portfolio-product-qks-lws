package com.zctop.portfolio.product.qks.lws.service;

import com.zctop.portfolio.product.qks.lws.model.ProductResponse;
import com.zctop.portfolio.product.qks.lws.model.db.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(String name, Double price);

    Product getProduct(Long id);

    Product updateProduct(Long id, String name, Double price);

    void deleteProduct(Long id);

    List<Product> getAll();

    List<Product> getByPrice(Double price);

    List<Product> getByMaxPrice(Double price);

    ProductResponse createResponse(Product product);

}
