package com.example.grocerybooking.service;

import com.example.grocerybooking.model.GroceryItem;
import com.example.grocerybooking.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {
    private final GroceryItemRepository groceryItemRepository;
    private final AtomicInteger orderCounter = new AtomicInteger(1);

    public OrderService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public String placeOrder(List<GroceryItem> items) {
        for (GroceryItem item : items) {
            GroceryItem existing = groceryItemRepository.getGroceryItemById(item.getId()).orElse(null);
            if (existing == null || existing.getQuantity() < item.getQuantity()) {
                return "Order failed! Insufficient stock for item: " + item.getName();
            }
            existing.setQuantity(existing.getQuantity() - item.getQuantity());
            groceryItemRepository.updateGroceryItem(existing);
        }
        return "Order #" + orderCounter.getAndIncrement() + " placed successfully!";
    }
}
