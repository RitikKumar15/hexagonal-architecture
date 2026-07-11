package com.hexa.pattern.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Table(name = "food_order")
@Entity(name = "food_order")
@Data
@Builder
public class FoodOrderEntity {
    @Id
    private String orderId;
    private Date orderAt;
    private String username;
    private String status;
    @Transient
    private Set<String> items;
}
