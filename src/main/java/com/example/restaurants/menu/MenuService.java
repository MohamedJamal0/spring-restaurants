package com.example.restaurants.menu;

import com.example.restaurants.menu.dto.MenuDto;
import com.example.restaurants.menu.dto.MenuItemAddRequest;
import com.example.restaurants.menu.dto.MenuItemDto;

public interface MenuService {

    public MenuItemDto addItemToMenu(MenuItemAddRequest menuItemAddRequest );
    public void removeItemFromMenu(Long id);
    public MenuDto getMenuByRestaurantId(Long id);

}



