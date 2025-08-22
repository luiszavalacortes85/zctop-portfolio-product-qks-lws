package com.zctop.portfolio.product.qks.lws.model.db;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(callSuper = true)
public class Product extends PanacheEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5969846354506929947L;

    public String name;
    public Double price;

    @ManyToOne
    public Customer customer;

}
