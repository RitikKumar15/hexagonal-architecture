package com.hexa.pattern.config;

import com.hexa.pattern.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderService getOrderService() {
        return new OrderService();
    }

}
