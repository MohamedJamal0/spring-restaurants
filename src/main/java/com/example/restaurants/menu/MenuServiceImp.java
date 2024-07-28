package com.example.restaurants.menu;


import com.example.restaurants.menu.dto.MenuDto;
import com.example.restaurants.menu.dto.MenuItemAddRequest;
import com.example.restaurants.menu.dto.MenuItemDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImp implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuMapper menuMapper;

    @Override
    public MenuItemDto addItemToMenu(MenuItemAddRequest menuItemAddRequest) {

        Menu menu = menuRepository.findById(menuItemAddRequest.menuId()).orElseThrow();

        MenuItem addMenuItemEntity = menuMapper.toAddMenuItemEntity(menuItemAddRequest);
        addMenuItemEntity.setMenu(menu);

        MenuItem menuItem = menuItemRepository.save(addMenuItemEntity);

        return menuMapper.toMenuItemDto(menuItem);

    }

    @Override
    public void removeItemFromMenu(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public MenuDto getMenuByRestaurantId(Long id) {
        return menuRepository.findMenuByRestaurantId(id)
                .map(menuMapper::toMenuDto)
                .orElseThrow();

    }

    @Override
    public MenuItem findMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElseThrow();
    }
}
