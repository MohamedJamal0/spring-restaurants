package com.example.restaurants.order.dto;

import com.example.restaurants.order.OrderStatus;
import com.example.restaurants.restaurant.Restaurant;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderDto(
        Long id,
        BigDecimal totalPrice,
        Instant orderTime,
        OrderStatus orderStatus,
        Restaurant restaurant
) {
}


