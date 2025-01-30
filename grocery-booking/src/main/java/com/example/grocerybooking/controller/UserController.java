package com.example.grocerybooking.controller;

import com.example.grocerybooking.model.GroceryItem;
import com.example.grocerybooking.service.GroceryService;
import com.example.grocerybooking.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final GroceryService groceryService;
    private final OrderService orderService;

    public UserController(GroceryService groceryService, OrderService orderService) {
        this.groceryService = groceryService;
        this.orderService = orderService;
    }

    @GetMapping("/items")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryService.getAllGroceryItems();
    }
    @PostMapping("/order")
    public String placeOrder(@RequestBody List<GroceryItem> items) {
        return orderService.placeOrder(items);
    }

}
