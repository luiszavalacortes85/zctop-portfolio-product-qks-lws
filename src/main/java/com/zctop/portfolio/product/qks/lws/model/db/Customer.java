package com.zctop.portfolio.product.qks.lws.model.db;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
public class Customer extends PanacheEntityBase implements Serializable {

    @Serial
    private static final long serialVersionUID = 2988221487827670835L;

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String rfc;
    public String email;

    public Customer(String name, String rfc, String email) {
        this.name = name;
        this.rfc = rfc;
        this.email = email;
    }


}
