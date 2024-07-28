package com.example.restaurants.payment.paymentStrategyImp;

import com.example.restaurants.order.Order;
import com.example.restaurants.payment.Payment;
import com.example.restaurants.payment.PaymentStrategy;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentStrategy implements PaymentStrategy {

    @Override
    public Payment processPayment(Order order, String paymentToken) {
        return null;
    }
}
