package com.example.restaurants.order;

import com.example.restaurants.cart.Cart;
import com.example.restaurants.cart.CartRepository;
import com.example.restaurants.order.dto.OrderAddRequest;
import com.example.restaurants.order.dto.OrderCheckoutRequest;
import com.example.restaurants.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final PaymentService paymentService;


    @Override
    public List<Order> getAllOrdersByRestaurantId(Long id , PageRequest paging) {
        return orderRepository.findAllByRestaurantId(id ,paging).toList();
    }

    @Override
    public Order createOrder(Long cartId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow();

        Order order = Order.builder()
                .totalPrice(cart.getTotalPrice())
                .orderStatus(OrderStatus.PENDING)
                .orderTime(Instant.now())
                .restaurant(cart.getRestaurant())
                .build();

        return order;
    }

    @Override
    public Order checkoutOrder(OrderCheckoutRequest orderCheckoutRequest) {

        Order order = createOrder(orderCheckoutRequest.cartId());

        paymentService.processPayment(orderCheckoutRequest.paymentMethod(), order , orderCheckoutRequest.paymentToken());

        order.setOrderStatus(OrderStatus.CONFIRMED);

        return orderRepository.save(order);
    }


}

