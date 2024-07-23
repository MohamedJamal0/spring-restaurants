package com.example.restaurants.menu;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {

    @Id
    @GeneratedValue
    @Column(name = "menu_item_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(cascade = {
            CascadeType.MERGE ,
            CascadeType.DETACH ,
            CascadeType.PERSIST ,
            CascadeType.REFRESH})
    @JoinColumn(name = "menu_id")
    @JsonBackReference
    private  Menu menu;

}
