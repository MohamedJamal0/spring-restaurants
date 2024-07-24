package com.example.restaurants.payment;

import com.example.restaurants.order.Order;

public interface PaymentStrategy {
    public Payment processPayment(Order order , String paymentToken);
}



// payment service process ;