package com.hexa.pattern.adapter.input.rest;

import com.hexa.pattern.domain.dto.FoodOrderDTO;
import com.hexa.pattern.domain.port.input.PlaceOrder;
import com.hexa.pattern.domain.port.input.TrackOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    private final PlaceOrder placeOrder;
    private final TrackOrder trackOrder;

    public FoodOrderController(PlaceOrder placeOrder, TrackOrder trackOrder) {
        this.placeOrder = placeOrder;
        this.trackOrder = trackOrder;
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody FoodOrderDTO orderDTO) {
        placeOrder.placeOrder(orderDTO);
        return ResponseEntity.ok("Order Placed!!");
    }

    @GetMapping("/track-order/{orderId}")
    public ResponseEntity<String> trackOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(trackOrder.trackOrder(orderId));
    }
}
