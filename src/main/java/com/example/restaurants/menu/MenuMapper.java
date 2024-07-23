package com.example.restaurants.menu;


import com.example.restaurants.menu.dto.MenuDto;
import com.example.restaurants.menu.dto.MenuItemAddRequest;
import com.example.restaurants.menu.dto.MenuItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuDto toMenuDto(Menu entity);

    @Mapping(target = "id" , ignore = true)
    MenuItem toAddMenuItemEntity(MenuItemAddRequest dto);

    MenuItemDto toMenuItemDto(MenuItem menuItem);
}
