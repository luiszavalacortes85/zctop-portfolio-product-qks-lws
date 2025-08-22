package com.zctop.portfolio.product.qks.lws.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7667501540533633496L;

    private Long id;

    private String name;

    private Double price;

    private Long cid;

}
