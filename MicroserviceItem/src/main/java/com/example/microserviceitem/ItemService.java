package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    WebClient webClient;

    @Autowired
    UserClient userClient;
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

    public boolean deleteItem(int id) {
        if (itemRepository.findById(id).isPresent()) {
            itemRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    public ItemRespose getItemById(int id) {
        Item i= itemRepository.findById(id).orElse(null);
        ItemRespose itemRespose=new ItemRespose(i);
        // postRespose.setUserResponse(getUserById(p.getUser_id()));
        itemRespose.setUser(userClient.getById(i.getUser_id()));

        return itemRespose;
    }
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public List<ItemRespose> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemRespose> itemResponses = new ArrayList<>();

        for (Item item : items) {
            ItemRespose itemRespose = new ItemRespose(item);
            // Fetch user information for the post
            UserResponse userResponse = userClient.getById(item.getUser_id());
            itemRespose.setUser(userResponse);
            itemResponses.add(itemRespose);
        }

        return itemResponses;
    }
    public List<UserResponse> getAllUsers() {
        List<UserResponse> users = userClient.getAll();

        return users;
    }
    public UserResponse getUserById(long userId){
        Mono<UserResponse> userResponse= webClient.get().uri("/"+userId).retrieve().bodyToMono(UserResponse.class);
        return userResponse.block();
    }

}
