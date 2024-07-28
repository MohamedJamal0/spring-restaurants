package com.example.restaurants.cart.dto;

import jakarta.validation.constraints.Min;

public record CartItemUpdateQuantityRequest(
        @Min(value = 1 , message = "minimum quantity is 1 ")
        Integer quantity
) {
}
