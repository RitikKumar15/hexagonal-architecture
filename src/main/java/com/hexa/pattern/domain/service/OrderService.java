package com.hexa.pattern.domain.service;

import com.hexa.pattern.adapter.output.OrderRepository;
import com.hexa.pattern.domain.dto.FoodOrderDTO;
import com.hexa.pattern.domain.port.input.PlaceOrder;
import com.hexa.pattern.domain.port.input.TrackOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

public class OrderService implements PlaceOrder, TrackOrder {

    @Autowired private OrderRepository orderRepository;

    @Override
    public void placeOrder(FoodOrderDTO orderDTO) {
        // Implement technology-agnostic business logic here
        orderDTO.setOrderAt(new Date(System.currentTimeMillis()));
        orderDTO.setStatus("Pending");
        orderDTO.setItems(Set.of("milk, almonds"));
        orderRepository.placeOrder(orderDTO);
    }

    @Override
    public String trackOrder(String orderId) {
        // Implement technology-agnostic business logic here
        return orderRepository.trackOrder(orderId);
    }
}
