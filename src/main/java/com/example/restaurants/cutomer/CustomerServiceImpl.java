package com.example.restaurants.cutomer;

import com.example.restaurants.auth.CustomerMapper;
import com.example.restaurants.auth.Role;
import com.example.restaurants.cart.Cart;
import com.example.restaurants.cart.CartService;
import com.example.restaurants.cutomer.dto.CustomerAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerMapper customerMapper;


    @Override
    public Customer create(CustomerAddRequest customerAddRequest) {



        Customer addEntity = customerMapper.toEntity(customerAddRequest);

        addEntity.setPassword(passwordEncoder.encode(customerAddRequest.password()));
        addEntity.setEmail(customerAddRequest.email());
        addEntity.setRole(Role.CUSTOMER);

        Cart cart = new Cart();
        cart.setCustomer(addEntity);
        addEntity.setCart(cart);

        return customerRepository.save(addEntity);
    }

    @Override
    public Customer findById(Long id) {

        return customerRepository.findById(id).orElseThrow();
    }
}