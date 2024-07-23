package com.example.restaurants.menu;

import com.example.restaurants.menu.dto.MenuDto;
import com.example.restaurants.menu.dto.MenuItemAddRequest;
import com.example.restaurants.menu.dto.MenuItemDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/items")
    @Validated
    public ResponseEntity<MenuItemDto> addItemToMenu(@Valid @RequestBody MenuItemAddRequest menuItemAddRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(menuService.addItemToMenu(menuItemAddRequest));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> removeItemFromMenu(@PathVariable Long id) {
        menuService.removeItemFromMenu(id);
        return ResponseEntity.ok("item with the id " + id + "is removed");
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<MenuDto> getMenuByRestaurantId(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getMenuByRestaurantId(id));
    }


}







