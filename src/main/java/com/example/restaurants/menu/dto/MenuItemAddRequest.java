package com.example.restaurants.menu.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record MenuItemAddRequest(
        @NotBlank(message = "Title cannot be empty")
        String title,

        @NotBlank(message = "Ingredients cannot be empty")
        String ingredients,

        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
        BigDecimal price,

        @NotNull(message = "Menu ID cannot be null")
        @Positive(message = "Menu ID must be positive")
        Long menuId
) {
}
