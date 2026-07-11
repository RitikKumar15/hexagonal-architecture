package com.hexa.pattern.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FoodOrderDTO {
    private String orderId;
    private Date orderAt;
    private String username;
    private String status;
    private Set<String> items;
}
