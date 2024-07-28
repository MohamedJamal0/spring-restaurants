package com.example.restaurants.order;

import com.example.restaurants.order.dto.OrderAddRequest;
import com.example.restaurants.order.dto.OrderCheckoutRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface OrderService {

   public List<Order> getAllOrdersByRestaurantId(Long id , PageRequest paging);
   public Order createOrder(Long cartId);

   public Order checkoutOrder(OrderCheckoutRequest orderCheckoutRequest);



}



