package com.example.restaurants.restaurantOnwer;

import com.example.restaurants.auth.Role;
import com.example.restaurants.restaurantOnwer.dto.RestaurantOwnerAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService {

    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestaurantOwnerMapper restaurantOwnerMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RestaurantOwner create(RestaurantOwnerAddRequest restaurantOwnerAddRequest) {

        RestaurantOwner addEntity = restaurantOwnerMapper.toEntity(restaurantOwnerAddRequest);

        addEntity.setPassword(passwordEncoder.encode(restaurantOwnerAddRequest.password()));
        addEntity.setRole(Role.RESTAURANT_OWNER);

        return restaurantOwnerRepository.save(addEntity);
    }

    @Override
    public RestaurantOwner findById(Long id) {

        return restaurantOwnerRepository.findById(id).orElseThrow();
    }


}
