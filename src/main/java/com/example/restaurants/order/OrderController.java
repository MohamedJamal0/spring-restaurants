package com.example.restaurants.order;

import com.example.restaurants.order.dto.OrderCheckoutRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/checkout")
    public Order checkout(@Valid @RequestBody OrderCheckoutRequest orderCheckoutRequest) {
        return orderService.checkoutOrder(orderCheckoutRequest);
    }

}
