package com.example.restaurants.restaurant;

import com.example.restaurants.restaurant.dto.RestaurantAddRequest;
import com.example.restaurants.restaurant.dto.RestaurantDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(
            @RequestParam(value ="page" , defaultValue = "0") Integer page,
            @RequestParam(value ="size" , defaultValue = "10") Integer size
    ) {
        PageRequest paging = PageRequest.of(page , size);
        return  ResponseEntity.ok(restaurantService.getAlLRestaurants(paging));

    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id ) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));

    }

    @PostMapping("")
    public  ResponseEntity<RestaurantDto> addRestaurant(@Valid @RequestBody RestaurantAddRequest restaurantAddRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restaurantService.addRestaurant(restaurantAddRequest));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("restaurant with id " + id + "is deleted");

    }
}


