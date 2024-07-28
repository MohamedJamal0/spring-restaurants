package com.example.restaurants.order.dto;

import jakarta.validation.constraints.NotNull;

public record OrderAddRequest(

        @NotNull(message = "cart id is required")
        Long cartId


) {
}




