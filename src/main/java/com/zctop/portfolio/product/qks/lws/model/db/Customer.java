package com.zctop.portfolio.product.qks.lws.model.db;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode(callSuper = true)
public class Customer extends PanacheEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2988221487827670835L;

    public String name;
    public String email;

    @OneToMany(mappedBy = "customer")
    public List<Product> products;

}
