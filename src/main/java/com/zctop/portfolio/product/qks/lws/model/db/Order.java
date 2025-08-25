package com.zctop.portfolio.product.qks.lws.model.db;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@Table(name = "orders")
@EqualsAndHashCode(callSuper = true)
public class Order extends PanacheEntityBase implements Serializable {

    @Serial
    private static final long serialVersionUID = -467681495039876577L;

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Order(Customer customer, Product product, LocalDateTime createdAt) {
        this.customer = customer;
        this.product = product;
        this.createdAt = createdAt;
    }

    public Order(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        this.createdAt = LocalDateTime.now();
    }
}
