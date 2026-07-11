package com.hexa.pattern.adapter.output.jpa;

import com.hexa.pattern.adapter.entity.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity, String> {
}
