package com.example.projectspring.service;

import com.example.projectspring.model.rocketLeague.Item;
import com.example.projectspring.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getAll() {return this.itemRepository.findAll();}
    @Override
    public Item getById(Long id) {return this.itemRepository.findById(id).get();}
    @Override
    public Item add(Item item) {return this.itemRepository.save(item);}
    @Override
    public Item modify(Item item) {
//        Optional<Item> byId = this.itemRepository.findById(item.getId());
//        if (byId.isPresent()){
//            byId = Optional.of(item);
            return this.itemRepository.save(item);
//        }
//        return item;
    }

    @Override
    public boolean delete(Item item) {
        try{
            this.itemRepository.delete(item);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }
}
