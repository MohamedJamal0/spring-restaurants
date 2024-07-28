package com.example.restaurants.auth;


import com.example.restaurants.auth.dto.LoginRequest;
import com.example.restaurants.cutomer.dto.CustomerAddRequest;
import com.example.restaurants.restaurantOnwer.RestaurantOwnerService;
import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/customer")
    ResponseEntity<String> registerCustomer (@Valid @RequestBody CustomerAddRequest customerAddRequest) {
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(authService.registerCustomer(customerAddRequest));
    }

    @PostMapping("/restaurantOwner")
    ResponseEntity<String> registerRestaurantOwner (@RequestBody @Valid RestaurantOwnerAddRequest restaurantOwnerAddRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authService.registerRestaurantOwner(restaurantOwnerAddRequest));
    }

    @PostMapping("/login")
     ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity
                .ok(authService.login(loginRequest.email() , loginRequest.password()));

    }



}
