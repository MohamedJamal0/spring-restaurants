package com.example.restaurants.cart.dto;

import java.math.BigDecimal;
import java.util.List;

public record CartDto(
        Long id,
        List<CartItemsDto> cartItems,
        Integer totalQuantity,
        RestaurantDto restaurant
) {
    public record RestaurantDto(
            Long id,
            String title
    ) {
    }

    public record CartItemsDto(
            Long id ,
            Integer quantity,
            BigDecimal unitPrice,
            BigDecimal totalPrice
    ) {}

}
