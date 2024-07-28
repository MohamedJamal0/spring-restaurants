package com.example.restaurants.cutomer;

import com.example.restaurants.cutomer.dto.CustomerAddRequest;

public interface CustomerService {

    Customer create(CustomerAddRequest customerAddRequest);
    Customer findById(Long id);
}
