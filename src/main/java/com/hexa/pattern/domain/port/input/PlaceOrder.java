package com.hexa.pattern.domain.port.input;

import com.hexa.pattern.domain.dto.FoodOrderDTO;

public interface PlaceOrder {
    void placeOrder(FoodOrderDTO orderDTO);
}
