package com.example.restaurants.auth;


import com.example.restaurants.cutomer.Customer;
import com.example.restaurants.cutomer.dto.CustomerAddRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerAddRequest dto);
}
