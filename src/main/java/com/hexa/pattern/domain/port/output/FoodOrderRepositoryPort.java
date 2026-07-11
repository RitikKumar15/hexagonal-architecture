package com.hexa.pattern.domain.port.output;

import com.hexa.pattern.domain.dto.FoodOrderDTO;

public interface FoodOrderRepositoryPort {
    void placeOrder(FoodOrderDTO orderDTO);
    String trackOrder(String orderId);
}
