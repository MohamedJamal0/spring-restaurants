package com.example.restaurants.order.dto;

import jakarta.validation.constraints.NotNull;

public record OrderCheckoutRequest(

        @NotNull(message = "payment method is required")
        String paymentMethod,

        @NotNull(message = "cart id is required")
        Long cartId,

        String paymentToken
)
{ }



