package com.zctop.portfolio.product.qks.lws.model.db;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
public class Product extends PanacheEntityBase implements Serializable {

    @Serial
    private static final long serialVersionUID = -5969846354506929947L;

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

}
