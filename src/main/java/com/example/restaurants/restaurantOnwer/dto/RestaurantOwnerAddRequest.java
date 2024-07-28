package com.example.restaurants.restaurantOnwer.dto;

import jakarta.validation.constraints.NotBlank;

public record RestaurantOwnerAddRequest (

        @NotBlank(message = "email is required")
        String email,
        @NotBlank(message = "password is required")
        String password,
        @NotBlank(message = "contact person is required")
        String contactPerson,
        @NotBlank(message = "phone number is required")
        String phoneNumber,
        @NotBlank(message = "address is required")
        String address


) {
}
