package com.zctop.portfolio.product.qks.lws.service.impl;

import com.zctop.portfolio.product.qks.lws.model.ProductResponse;
import com.zctop.portfolio.product.qks.lws.model.db.Product;
import com.zctop.portfolio.product.qks.lws.repository.ProductRepository;
import com.zctop.portfolio.product.qks.lws.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Product addProduct(String name, Double price) {
        log.info("Add product [{}] with price [{}]", name, price);
        return productRepository.addProduct(name, price);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        log.info("Get product by id [{}]", id);
        return productRepository.getProduct(id);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Product updateProduct(Long id, String name, Double price) {
        log.info("Update product [{}] with id [{}]", name, id);
        return productRepository.updateProduct(id, name, price);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteProduct(Long id) {
        log.info("Delete product by id [{}]", id);
        productRepository.deleteProduct(id);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        log.info("Get all products");
        return productRepository.getAll();
    }

    @Override
    @Transactional
    public List<Product> getByPrice(Double price) {
        log.info("Get products by price [{}]", price);
        return productRepository.getByPrice(price);
    }

    @Override
    @Transactional
    public List<Product> getByMaxPrice(Double price) {
        log.info("Get products by max price [{}]", price);
        return productRepository.getByMaxPrice(price);
    }

    @Override
    public ProductResponse createResponse(Product product) {
        if (product == null) {
            return ProductResponse.builder()
                    .code(1).description("Error")
                    .build();
        }
        List<Product> products = new ArrayList<>();
        products.add(product);
        return ProductResponse.builder()
                .code(0).description("Success")
                .entity(products)
                .build();
    }
}
