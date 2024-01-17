package com.example.userordermanagement.service;

import com.example.userordermanagement.domain.Order;
import com.example.userordermanagement.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order placedOrder = orderService.placeOrder(order);

        assertEquals(order, placedOrder);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testCheckPreviousOrders() {
        List<Order> orders = Collections.singletonList(new Order());
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> foundOrders = orderService.checkPreviousOrders();

        assertEquals(orders, foundOrders);
        verify(orderRepository, times(1)).findAll();
    }
}