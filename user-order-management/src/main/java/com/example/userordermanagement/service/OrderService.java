package com.example.userordermanagement.service;

import com.example.userordermanagement.domain.Order;
import com.example.userordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final EventPublisherService eventPublisherService;

    @Autowired
    public OrderService(OrderRepository orderRepository, EventPublisherService eventPublisherService) {
        this.orderRepository = orderRepository;
        this.eventPublisherService = eventPublisherService;
    }

    public Order placeOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        OrderPlacedEvent event = convertToOrderPlacedEvent(savedOrder);
        eventPublisherService.publishOrderPlacedEvent(event);
        return savedOrder;
    }

    private OrderPlacedEvent convertToOrderPlacedEvent(Order order) {
        OrderPlacedEvent event = new OrderPlacedEvent();
        event.setOrderId(order.getOrderId());
        event.setFoodSelection(order.getFoodSelection());
        event.setQuantity(order.getQuantity());
        event.setSpecialRequest(order.getSpecialRequest());
        event.setDeliveryAddress(order.getDeliveryAddress());
        event.setPaymentMethod(order.getPaymentMethod());
        event.setOrderAmount(order.getOrderAmount());
        return event;
    }
}