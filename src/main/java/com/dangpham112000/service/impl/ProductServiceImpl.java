package com.dangpham112000.service.impl;

import com.dangpham112000.entity.ProductEntity;
import com.dangpham112000.repository.ProductRepository;
import com.dangpham112000.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProduct() {
        return productRepository.findAllProduct();
    }
}