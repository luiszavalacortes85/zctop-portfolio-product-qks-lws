package com.zctop.portfolio.product.qks.lws.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zctop.portfolio.product.qks.lws.model.db.Product;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5089722993394052335L;

    private int code;
    private String description;
    private List<Product> entity;
    private List<Object> errors;
}
