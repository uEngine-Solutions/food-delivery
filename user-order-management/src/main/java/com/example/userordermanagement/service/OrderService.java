package com.example.userordermanagement.service;

import com.example.userordermanagement.domain.Order;
import com.example.userordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        // Logic to place an order
        // Publish OrderPlaced event
        return orderRepository.save(order);
    }

    public void cancelOrder(UUID orderId) {
        // Logic to cancel an order
        // Publish OrderCancelled event
        orderRepository.deleteById(orderId);
    }

    public List<Order> checkPreviousOrders() {
        // Logic to retrieve previous orders
        // Publish PreviousOrdersChecked event
        return orderRepository.findAll();
    }

    public void confirmOrder(UUID orderId) {
        // Logic to confirm an order
        // No event is published for this action in the model
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setOrderStatus("Confirmed");
        orderRepository.save(order);
    }
}