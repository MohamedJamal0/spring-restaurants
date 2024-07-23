package com.example.restaurants.restaurant;

import com.example.restaurants.menu.Menu;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private String status;

    @Column(name = "minimum_order", nullable = false)
    private BigDecimal minimumOrder;

    @Column(name = "delivery_fee", nullable = false)
    private BigDecimal deliveryFee;

    @Column(name = "opening_time", nullable = false)
    private Instant openingTime;

    @Column(name = "closing_time", nullable = false)
    private Instant closingTime;

    @OneToOne(mappedBy = "restaurant" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Menu menu;

}
