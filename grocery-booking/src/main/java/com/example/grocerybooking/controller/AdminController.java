package com.example.grocerybooking.controller;

import com.example.grocerybooking.model.GroceryItem;
import com.example.grocerybooking.service.GroceryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final GroceryService groceryService;

    public AdminController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @PostMapping("/add")
    public String addGroceryItem(@RequestBody GroceryItem item) {
        groceryService.addGroceryItem(item);
        return "Grocery item added successfully!";
    }

    @GetMapping("/items")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryService.getAllGroceryItems();
    }

    @GetMapping("/item/{id}")
    public Optional<GroceryItem> getGroceryItemById(@PathVariable int id) {
        return groceryService.getGroceryItemById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGroceryItem(@PathVariable int id) {
        groceryService.deleteGroceryItem(id);
        return "Grocery item deleted successfully!";
    }

    @PutMapping("/update")
    public String updateGroceryItem(@RequestBody GroceryItem item) {
        groceryService.updateGroceryItem(item);
        return "Grocery item updated successfully!";
    }
    @PutMapping("/update-inventory/{id}")
    public String updateInventory(@PathVariable int id, @RequestParam int quantity) {
        Optional<GroceryItem> item = groceryService.getGroceryItemById(id);
        if (item.isPresent()) {
            GroceryItem updatedItem = item.get();
            updatedItem.setQuantity(quantity);
            groceryService.updateGroceryItem(updatedItem);
            return "Inventory updated successfully!";
        }
        return "Item not found!";
    }

}
