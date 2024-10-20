package com.dangpham112000;

import com.dangpham112000.entity.OrderEntity;
import com.dangpham112000.entity.ProductEntity;
import com.dangpham112000.repository.OrderRepository;
import com.dangpham112000.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void manyToManyTest() {
        ProductEntity product1 = new ProductEntity();
        ProductEntity product2 = new ProductEntity();

        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        OrderEntity order3 = new OrderEntity();

        product1.setProductName("p1");
        product2.setProductName("p2");
        product1.setProductPrice(new BigDecimal("10"));
        product2.setProductPrice(new BigDecimal("20"));

        order1.setUserId(1);
        order2.setUserId(2);

        product1.setOrderList(List.of(order1, order2, order3));
        product2.setOrderList(List.of(order1, order2));

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        productRepository.save(product1);
        productRepository.save(product2);
    }
}
