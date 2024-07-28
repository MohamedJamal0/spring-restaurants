package com.example.restaurants.restaurant;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {

    @EntityGraph(attributePaths = "menu.menuItems")
    Optional<Restaurant> findById(Long id);
}
