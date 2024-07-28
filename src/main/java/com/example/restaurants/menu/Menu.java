package com.example.restaurants.menu;

import com.example.restaurants.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "menus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @OneToOne(cascade = {
            CascadeType.MERGE ,
            CascadeType.DETACH ,
            CascadeType.PERSIST ,
            CascadeType.REFRESH})
    @JoinColumn(name = "restaurant_id" )
    @JsonBackReference
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MenuItem> menuItems;



}




