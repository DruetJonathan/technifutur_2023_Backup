package com.example.projectspring.controller;

import com.example.projectspring.model.rocketLeague.Item;
import com.example.projectspring.service.ItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    ItemServiceImpl itemService;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Item>> getItems() {
        return ResponseEntity.ok(this.itemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.add(item));
    }
    // TODO : faire le update et delete
    @PostMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item,@PathVariable Long id) {
        return ResponseEntity.ok(itemService.modify(item));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteItem(@RequestBody Item item, @PathVariable Long id) {
        return ResponseEntity.ok(itemService.delete(item));
    }
}

