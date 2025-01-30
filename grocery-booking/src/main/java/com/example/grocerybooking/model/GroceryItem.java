package com.example.grocerybooking.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItem {
    private int id;
    private String name;
    private double price;
    private int quantity;
}
