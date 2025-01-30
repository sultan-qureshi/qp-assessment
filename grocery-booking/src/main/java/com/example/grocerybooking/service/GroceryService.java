package com.example.grocerybooking.service;

import com.example.grocerybooking.model.GroceryItem;
import com.example.grocerybooking.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {
    private final GroceryItemRepository repository;

    public GroceryService(GroceryItemRepository repository) {
        this.repository = repository;
    }

    public void addGroceryItem(GroceryItem item) {
        repository.addGroceryItem(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return repository.getAllGroceryItems();
    }

    public Optional<GroceryItem> getGroceryItemById(int id) {
        return repository.getGroceryItemById(id);
    }

    public void deleteGroceryItem(int id) {
        repository.deleteGroceryItem(id);
    }

    public void updateGroceryItem(GroceryItem item) {
        repository.updateGroceryItem(item);
    }
}
