package com.dangpham112000.service;

import com.dangpham112000.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProduct();
}
