package com.example.userordermanagement.service;

import com.example.userordermanagement.dto.OrderPlacedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

    private final StreamBridge streamBridge;

    @Autowired
    public EventPublisherService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publishOrderPlacedEvent(OrderPlacedEvent event) {
        streamBridge.send("orderPlacedEventSupplier-out-0", event);
    }
}