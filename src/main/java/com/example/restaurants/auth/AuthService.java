package com.example.restaurants.auth;
import com.example.restaurants.cutomer.Customer;
import com.example.restaurants.cutomer.dto.CustomerAddRequest;
import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;


public interface AuthService {
    String registerCustomer(CustomerAddRequest customerAddRequest);
    String registerRestaurantOwner(RestaurantOwnerAddRequest restaurantOwnerAddRequest);
    String login(String email , String password);
}
