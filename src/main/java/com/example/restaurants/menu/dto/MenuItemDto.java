package com.example.restaurants.menu.dto;

import java.math.BigDecimal;

public record MenuItemDto(
        Long id,
        String title,
        String ingredients,
        BigDecimal price
) {
}
