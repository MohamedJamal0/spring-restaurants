package com.example.restaurants.payment;


import com.example.restaurants.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public void processPayment(String paymentMethod , Order order , String paymentToken);
}