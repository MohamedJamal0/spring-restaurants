package com.example.restaurants.cutomer;


import com.example.restaurants.auth.Role;
import com.example.restaurants.auth.User;
import com.example.restaurants.cart.Cart;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@Builder
public class Customer extends User {
    
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL )
    private Cart cart;

    public Customer() {
        setRole(Role.CUSTOMER);
    }

}
