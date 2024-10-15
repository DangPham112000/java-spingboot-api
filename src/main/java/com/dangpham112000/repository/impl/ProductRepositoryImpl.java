package com.dangpham112000.repository.impl;

import com.dangpham112000.entity.ProductEntity;
import com.dangpham112000.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("cai ban");
        productEntity.setProductPrice(new BigDecimal("69"));
        return productEntity;
    }

    @Override
    public List<ProductEntity> findAllProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("cai ban");
        productEntity.setProductPrice(new BigDecimal("69"));
        return List.of(productEntity);
    }
}
