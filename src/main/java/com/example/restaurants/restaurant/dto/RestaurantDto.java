package com.example.restaurants.restaurant.dto;

import com.example.restaurants.menu.Menu;
import com.example.restaurants.menu.MenuItem;
import com.example.restaurants.menu.dto.MenuDto;

import java.math.BigDecimal;
import java.time.Instant;

public record RestaurantDto(
        Long id,
        String title,
        String subtitle,
        String location,
        String status,
        BigDecimal minimumOrder,
        BigDecimal deliveryFee,
        Instant openingTime,
        Instant closingTime,
        Menu menu
) {}

