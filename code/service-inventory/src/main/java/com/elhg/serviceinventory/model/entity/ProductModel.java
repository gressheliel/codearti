package com.elhg.serviceinventory.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class ProductModel {

    @Id
    private Integer id;

    private String code;

    @Column("nameProduct")
    private String nameProduct;

    private int stock;

    private BigDecimal price;
}
