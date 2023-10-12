package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item AddItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(int id, Item newItem) {

        if (itemRepository.findById(id).isPresent()) {
            Item existingItem = itemRepository.findById(id).get();
            existingItem.setTitle(newItem.getTitle());
            existingItem.setDescription(newItem.getDescription());
            existingItem.setCategory(newItem.getCategory());
            existingItem.setState(newItem.getState());
            return itemRepository.save(existingItem);
        } else
            return null;
    }

    public String deleteItem(int id) {
        if (itemRepository.findById(id).isPresent()) {
            itemRepository.deleteById(id);
            return "Item supprimé";
        } else
            return "Item non supprimé";
    }

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }
}
