package com.example.restaurants.auth;

import com.example.restaurants.config.JwtService;
import com.example.restaurants.cutomer.Customer;
import com.example.restaurants.cutomer.CustomerService;
import com.example.restaurants.cutomer.dto.CustomerAddRequest;
import com.example.restaurants.restaurantOnwer.RestaurantOwner;
import com.example.restaurants.restaurantOnwer.RestaurantOwnerService;
import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final CustomerService customerService;
    private final RestaurantOwnerService restaurantOwnerService;
    private final JwtService jwtService;


    @Override
    public String registerCustomer(CustomerAddRequest customerAddRequest) {

        Customer customer = customerService.create(customerAddRequest);
        return  jwtService.generateToken(customer);

    }

    @Override
    public String registerRestaurantOwner(RestaurantOwnerAddRequest restaurantOwnerAddRequest) {

        RestaurantOwner restaurantOwner = restaurantOwnerService.create(restaurantOwnerAddRequest);
        return jwtService.generateToken(restaurantOwner);
    }


    @Override
    public String login(String email, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );

        User user = userRepository.findByEmail(email).orElseThrow();

        return jwtService.generateToken(user);
    }


}
