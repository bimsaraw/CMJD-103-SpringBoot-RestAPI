package com.ijse.database.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.database.dto.OrderDTO;
import com.ijse.database.entity.Order;
import com.ijse.database.entity.Product;
import com.ijse.database.repository.OrderRepository;
import com.ijse.database.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        List<Long> productIds = orderDTO.getProducts();

        Set<Product> products = new HashSet<>();
        Double total = 0.0;

        for(Long productId : productIds) { //Looping through product Ids.
            Product product = productRepository.findById(productId).orElse(null);

            if(product != null && product.getQty() != 0) {
                //add this to the Product Set
                products.add(product);
                total = total + product.getPrice();

                product.setQty(product.getQty() - 1);
                productRepository.save(product);
            }
        }

        Double tax = (total/100) * 15;
        LocalDateTime dateTime = LocalDateTime.now();

        Order order = new Order();
        order.setTotal(total);
        order.setTax(tax);
        order.setDateTime(dateTime);
        order.setProducts(products);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
