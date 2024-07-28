package com.example.restaurants.restaurantOnwer;



import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantOwnerMapper {
    RestaurantOwner toEntity(RestaurantOwnerAddRequest dto);
}
