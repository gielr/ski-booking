package com.github.project.service;

import com.github.project.dto.OrderDTO;
import com.github.project.model.Order;
import org.springframework.data.domain.Sort;

import java.util.Set;

public interface OrderService {
    Order findById(Long id);
    Set<Order> findAll();
    Order createOrder(OrderDTO orders);
    void deleteOrder(Long id);
    Set<Order> findAllByClientId(Long clientId);
}
