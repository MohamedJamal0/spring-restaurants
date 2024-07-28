package com.example.restaurants.restaurantOnwer;

import com.example.restaurants.auth.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant_owners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOwner extends User {

    @Column(nullable = false)
    private String contactPerson;

    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;

    @Column(name = "address" , nullable = false)
    private String address;

}