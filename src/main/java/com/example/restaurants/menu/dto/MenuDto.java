package com.example.restaurants.menu.dto;

import com.example.restaurants.menu.MenuItem;

import java.util.List;

public record MenuDto(
        Long id,
        List<MenuItem> menuItems

) {
}
