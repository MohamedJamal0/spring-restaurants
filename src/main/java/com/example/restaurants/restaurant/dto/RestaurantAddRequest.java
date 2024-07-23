package com.example.restaurants.restaurant.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

public record RestaurantAddRequest(

        @NotBlank(message = "Title is mandatory")
        String title,

        @NotBlank(message = "Subtitle is mandatory")
        String subtitle,

        @NotBlank(message = "Location is mandatory")
        String location,

        @NotBlank(message = "Status is mandatory")
        String status,

        @NotNull(message = "Minimum order is mandatory")
        @DecimalMin(value = "0.00", inclusive = false, message = "Minimum order must be greater than 0")
        BigDecimal minimumOrder,

        @NotNull(message = "Delivery fee is mandatory")
        @DecimalMin(value = "0.00", inclusive = false, message = "Delivery fee must be greater than 0")
        BigDecimal deliveryFee,

        @NotNull(message = "Opening time is mandatory")
        Instant openingTime,

        @NotNull(message = "Closing time is mandatory")
        Instant closingTime
) {
}
