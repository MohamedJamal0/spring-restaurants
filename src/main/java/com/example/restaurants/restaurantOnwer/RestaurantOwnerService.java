package com.example.restaurants.restaurantOnwer;

import com.example.restaurants.restaurant.Restaurant;
import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;

public interface RestaurantOwnerService {
    RestaurantOwner create(RestaurantOwnerAddRequest restaurantOwnerAddRequest);

    RestaurantOwner findById(Long id);
}
