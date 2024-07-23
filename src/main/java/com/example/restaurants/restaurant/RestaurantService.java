package com.example.restaurants.restaurant;

import com.example.restaurants.menu.Menu;
import com.example.restaurants.menu.MenuRepository;
import com.example.restaurants.restaurant.dto.RestaurantAddRequest;
import com.example.restaurants.restaurant.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private  final RestaurantRepository restaurantRepository;
    private  final RestaurantMapper restaurantMapper;
    private  final MenuRepository menuRepository;


    public List<RestaurantDto> getAlLRestaurants(PageRequest paging) {
        return  restaurantRepository.findAll(paging)
                .map(restaurantMapper::toDto)
                .stream().toList();
    }

    public RestaurantDto getRestaurantById(Long id) {
        return restaurantRepository.findById(id).map(restaurantMapper::toDto).orElseThrow();
    }

    public RestaurantDto addRestaurant(RestaurantAddRequest restaurantAddRequest) {

        Restaurant addEntity = restaurantMapper.toAddEntity(restaurantAddRequest);
        Menu menu = new Menu();
        menu.setRestaurant(addEntity);
        addEntity.setMenu(menu);
        Restaurant restaurant = restaurantRepository.save(addEntity);

        return restaurantMapper.toDto(restaurant);
    }

    public  void deleteRestaurant(Long id ) {
         restaurantRepository.deleteById(id);
    }




}

