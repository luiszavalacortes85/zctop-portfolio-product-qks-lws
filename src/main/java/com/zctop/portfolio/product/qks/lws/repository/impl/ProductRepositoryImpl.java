package com.zctop.portfolio.product.qks.lws.repository.impl;

import com.zctop.portfolio.product.qks.lws.exception.ProductException;
import com.zctop.portfolio.product.qks.lws.model.db.Customer;
import com.zctop.portfolio.product.qks.lws.model.db.Product;
import com.zctop.portfolio.product.qks.lws.repository.ProductRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product addProduct(String name, Double price) {
        var product = new Product(name, price);
        product.persist();
        return product;
    }

    @Override
    public Product getProduct(Long id) {
        return Product.findById(id);
    }

    @Override
    public Product updateProduct(Long id, String name, Double price) {
        Product product = Product.findById(id);
        if (product == null) {
            throw new ProductException("Product not found", 404);
        }
        product.name = name;
        product.price = price;
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = Product.findById(id);
        if (product == null) {
            throw new ProductException("Product not found", 404);
        }
        product.delete();
    }

    @Override
    public List<Product> getAll() {
        return Product.listAll();
    }

    @Override
    public List<Product> getByPrice(Double price) {
        return Product.find("price = :price", Parameters.with("price", price)).list();
    }

    @Override
    public List<Product> getByMaxPrice(Double price) {
        return Product.find("price <= :price", Parameters.with("price", price)).list();
    }
}
