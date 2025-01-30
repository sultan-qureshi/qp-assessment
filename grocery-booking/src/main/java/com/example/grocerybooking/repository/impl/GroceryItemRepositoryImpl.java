package com.example.grocerybooking.repository.impl;

import com.example.grocerybooking.model.GroceryItem;
import com.example.grocerybooking.repository.GroceryItemRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroceryItemRepositoryImpl implements GroceryItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public GroceryItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<GroceryItem> groceryItemRowMapper = (rs, rowNum) ->
            new GroceryItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"));

    @Override
    public void addGroceryItem(GroceryItem item) {
        String sql = "INSERT INTO grocery_items (name, price, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getQuantity());
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        String sql = "SELECT * FROM grocery_items";
        return jdbcTemplate.query(sql, groceryItemRowMapper);
    }

    @Override
    public Optional<GroceryItem> getGroceryItemById(int id) {
        String sql = "SELECT * FROM grocery_items WHERE id = ?";
        List<GroceryItem> items = jdbcTemplate.query(sql, groceryItemRowMapper, id);
        return items.stream().findFirst();
    }

    @Override
    public void deleteGroceryItem(int id) {
        String sql = "DELETE FROM grocery_items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateGroceryItem(GroceryItem item) {
        String sql = "UPDATE grocery_items SET name = ?, price = ?, quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getQuantity(), item.getId());
    }
}
