package com.example.restaurants.payment.paymentStrategyImp;

import com.example.restaurants.order.Order;
import com.example.restaurants.payment.Payment;
import com.example.restaurants.payment.PaymentMethod;
import com.example.restaurants.payment.PaymentStatus;
import com.example.restaurants.payment.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public Payment processPayment(Order order, String paymentToken) {

        Payment payment  = Payment.builder()
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.COMPLETED)
                .paymentTime(Instant.now())
                .order(order)
                .amount(order.getTotalPrice())
                .build();

        return payment;


    }
}



