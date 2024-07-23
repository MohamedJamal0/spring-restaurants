package com.example.restaurants.restaurant;

import com.example.restaurants.restaurant.dto.RestaurantAddRequest;
import com.example.restaurants.restaurant.dto.RestaurantDto;
import com.example.restaurants.restaurant.dto.RestaurantUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {


    RestaurantDto toDto (Restaurant restaurant);

    Restaurant toUpdateEntity(RestaurantUpdateRequest dto);

    @Mapping(target = "id" , ignore = true)
    Restaurant toAddEntity(RestaurantAddRequest dto);

}