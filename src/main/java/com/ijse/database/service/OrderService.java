package com.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.database.dto.OrderDTO;
import com.ijse.database.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(OrderDTO orderDTO);
    Order getOrderById(Long id);
}
