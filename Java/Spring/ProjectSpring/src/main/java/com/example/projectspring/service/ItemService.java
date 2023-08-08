package com.example.projectspring.service;

import com.example.projectspring.model.rocketLeague.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {
    Iterable<Item> getAll();
    Item getById(Long id);

    Item add(Item item);
    Item modify(Item item);
    boolean delete(Item item);
}
