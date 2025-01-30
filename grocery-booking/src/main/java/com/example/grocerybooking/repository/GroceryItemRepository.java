package com.example.grocerybooking.repository;

import com.example.grocerybooking.model.GroceryItem;
import java.util.List;
import java.util.Optional;

public interface GroceryItemRepository {
    void addGroceryItem(GroceryItem item);
    List<GroceryItem> getAllGroceryItems();
    Optional<GroceryItem> getGroceryItemById(int id);
    void deleteGroceryItem(int id);
    void updateGroceryItem(GroceryItem item);
}
