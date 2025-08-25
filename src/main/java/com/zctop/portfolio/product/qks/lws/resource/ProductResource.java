package com.zctop.portfolio.product.qks.lws.resource;

import com.zctop.portfolio.product.qks.lws.model.ProductRequest;
import com.zctop.portfolio.product.qks.lws.model.ProductResponse;
import com.zctop.portfolio.product.qks.lws.model.db.Product;
import com.zctop.portfolio.product.qks.lws.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/products")
@ApplicationScoped
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductService productService;

    @GET
    @Path("/get/")
    public ProductResponse getAll() {
        List<Product> products = productService.getAll();
        if (products.isEmpty()) {
            return ProductResponse.builder()
                    .code(1).description("Error")
                    .build();
        }
        return ProductResponse.builder()
                .code(0).description("Success")
                .entity(products)
                .build();
    }

    @GET
    @Path("/price/{exactPrice}")
    public ProductResponse getByPrice(@PathParam("exactPrice") Boolean exactPrice, ProductRequest productRequest) {
        List<Product> products;
        if(exactPrice) {
            products = productService.getByMaxPrice(productRequest.getPrice());
        } else {
            products = productService.getByPrice(productRequest.getPrice());
        }
        if (products.isEmpty()) {
            return ProductResponse.builder()
                    .code(1).description("Error")
                    .build();
        }
        return ProductResponse.builder()
                .code(0).description("Success")
                .entity(products)
                .build();
    }

    @GET
    @Path("/get/{id}")
    public ProductResponse getOne(@PathParam("id") Long id) {
        var product = productService.getProduct(id);
        return productService.createResponse(product);
    }

    @POST
    @Path("/add/")
    public ProductResponse create(ProductRequest productRequest) {
        var product = productService.addProduct(productRequest.getName(), productRequest.getPrice());
        return productService.createResponse(product);
    }

    @PUT
    @Path("/update/")
    public ProductResponse update(ProductRequest productRequest) {
        var product = productService.updateProduct(productRequest.getId(), productRequest.getName(),
                                                   productRequest.getPrice());
        return productService.createResponse(product);
    }

    @DELETE
    @Path("/delete/{id}")
    public ProductResponse delete(@PathParam("id") Long id) {
        var product = productService.getProduct(id);
        productService.deleteProduct(product.id);
        product.name = null;
        product.price = null;
        return productService.createResponse(product);
    }

}
