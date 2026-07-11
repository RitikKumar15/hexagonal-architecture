package com.hexa.pattern.adapter.output;

import com.hexa.pattern.adapter.entity.FoodOrderEntity;
import com.hexa.pattern.adapter.output.jpa.FoodOrderRepository;
import com.hexa.pattern.domain.dto.FoodOrderDTO;
import com.hexa.pattern.domain.port.output.FoodOrderRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderRepository implements FoodOrderRepositoryPort {

    private FoodOrderRepository foodOrderRepository;

    @Override
    public void placeOrder(FoodOrderDTO orderDTO) {
        foodOrderRepository.save(getFoodOrderEntity(orderDTO));
    }

    @Override
    public String trackOrder(String orderId) {
        FoodOrderEntity orderEntity = foodOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!!"));
        return orderEntity.getStatus();
    }

    private FoodOrderEntity getFoodOrderEntity(FoodOrderDTO orderDTO) {
        return FoodOrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .orderAt(orderDTO.getOrderAt())
                .username(orderDTO.getUsername())
                .status(orderDTO.getStatus())
                .items(orderDTO.getItems())
                .build();
    }
}
