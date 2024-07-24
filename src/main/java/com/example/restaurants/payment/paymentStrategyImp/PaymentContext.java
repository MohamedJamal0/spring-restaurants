package com.example.restaurants.payment.paymentStrategyImp;

import com.example.restaurants.order.Order;
import com.example.restaurants.payment.Payment;
import com.example.restaurants.payment.PaymentMethod;
import com.example.restaurants.payment.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentContext {

    private final CashPaymentStrategy cashPaymentStrategy;
    private final StripePaymentStrategy stripePaymentStrategy;

    public Payment processPayment(String paymentMethod ,Order order,String paymentToken) {

        PaymentStrategy paymentStrategy = switch (PaymentMethod.valueOf(paymentMethod)) {
            case STRIPE -> stripePaymentStrategy;
            case CASH -> cashPaymentStrategy;
            default -> throw new IllegalArgumentException("Unsupported payment method");
        };

       return  paymentStrategy.processPayment(order , paymentToken);
    }
}
