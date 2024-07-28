package com.example.restaurants.cart;


import com.example.restaurants.cart.dto.CartDto;
import com.example.restaurants.cart.dto.CartItemAddRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "id" , ignore = true)
    CartItem toCartItemEntity(CartItemAddRequest dto);

    @Mapping(source = "totalQuantity", target = "totalQuantity")
    @Mapping(source = "restaurant" , target = "restaurant")
    @Mapping(source = "cartItems" , target = "cartItems")
    CartDto toCartDto(Cart cart);

}


