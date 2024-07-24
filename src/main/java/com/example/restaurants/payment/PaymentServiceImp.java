package com.example.restaurants.payment;


import com.example.restaurants.order.Order;
import com.example.restaurants.payment.paymentStrategyImp.PaymentContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImp implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentContext paymentContext;

    @Override
    public void processPayment(String paymentMethod, Order order, String paymentToken) {
        Payment payment = paymentContext.processPayment(paymentMethod , order , paymentToken);
        paymentRepository.save(payment);

    }

}
