package com.dangpham112000.entity;

import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "java_product_001")
public class ProductEntity {

    private Long id;
    private String ProductName;
    private BigDecimal ProductPrice;

    // get

    // set
}
