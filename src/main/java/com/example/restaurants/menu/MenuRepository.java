package com.example.restaurants.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu , Long> {

    Optional<Menu> findMenuByRestaurantId(Long restaurantId);
}
