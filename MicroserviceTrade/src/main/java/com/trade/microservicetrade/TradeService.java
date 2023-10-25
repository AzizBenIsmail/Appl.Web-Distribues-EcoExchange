package com.trade.microservicetrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final UserClient userClient;
    private final ItemClient itemClient;


    @Autowired
    public TradeService(TradeRepository tradeRepository, UserClient userClient, ItemClient itemClient) {
        this.tradeRepository = tradeRepository;
        this.userClient = userClient;
        this.itemClient = itemClient;

    }
    public Trade createTrade(Trade trade) {
        // Check if the offered item and requested item exist
        ResponseEntity<Item> offeredItemResponse = itemClient.createItem(trade.getOfferedItem());
        ResponseEntity<Item> requestedItemResponse = itemClient.createItem(trade.getRequestedItem());

        // Fetch the user information

        // Check if the items and user were created successfully


            Item offeredItem = offeredItemResponse.getBody();
            Item requestedItem = requestedItemResponse.getBody();
            User user = userClient.addUser(trade.getUser());

            // Set the fetched items and user in the trade
            trade.setOfferedItem(offeredItem);
            trade.setRequestedItem(requestedItem);
            trade.setUser(user);
System.out.println(trade);
            // Save the trade
            return tradeRepository.save(trade);

    }


    public Trade getTradeById(long tradeId) {
        Trade trade = tradeRepository.findById(tradeId).orElse(null);
        if (trade != null) {
            // Fetch user and items if needed
            User user = userClient.getById(trade.getUser().getId());
            Item offeredItem = itemClient.getItemById(trade.getOfferedItem().getId());
            Item requestedItem = itemClient.getItemById(trade.getRequestedItem().getId());

            // Set the fetched user and items in the trade
            trade.setOfferedItem(offeredItem);
            trade.setRequestedItem(requestedItem);
            trade.setUser(user);
        }
        return trade;
    }

    public List<Trade> getAllTradesWithDetails() {
        List<Trade> trades = tradeRepository.findAll(); // Fetch all trades from your repository

        for (Trade trade : trades) {
            // Use Feign clients to fetch user and item information
            User user = userClient.getById(trade.getUser().getId());
            Item offeredItem = itemClient.getItemById(trade.getOfferedItem().getId());
            Item requestedItem = itemClient.getItemById(trade.getRequestedItem().getId());

            // Set user and item details in the trade object
            trade.setUser(user);
            trade.setOfferedItem(offeredItem);
            trade.setRequestedItem(requestedItem);
        }

        return trades;
    }


    public User getUserById(Long userId) {
        return userClient.getById(userId);
    }
    public List<User> getAllUsers() {
        return userClient.getAllUsers();
    }

    public List<Item> getAllItems() {
        return itemClient.getAllItems();
    }

    public Item getItemById(int id) {
        return itemClient.getItemById(id);
    }

    public Trade updateTrade(Long tradeId, Trade updatedTrade) {
        // Retrieve the existing trade from your repository
        Trade existingTrade = tradeRepository.findById(tradeId).orElse(null);

        if (existingTrade == null) {
            return null;
        }

        // Update the trade properties with the values from updatedTrade
        existingTrade.setTradeStartDate(updatedTrade.getTradeStartDate());
        existingTrade.setTradeEndDate(updatedTrade.getTradeEndDate());
        existingTrade.setStatus(updatedTrade.getStatus());

        // Update offeredItem and requestedItem if they need to be changed
        existingTrade.setOfferedItem(updatedTrade.getOfferedItem());
        existingTrade.setRequestedItem(updatedTrade.getRequestedItem());

        // Update the associated User if needed
        existingTrade.setUser(updatedTrade.getUser());

        // Save the updated trade back to the repository
        tradeRepository.save(existingTrade);

        return existingTrade;
    }


    public void deleteTrade(long tradeId) {
        // Check if the trade exists by its ID
        Trade trade = tradeRepository.findById(tradeId)
                .orElse(null);

        // Delete the trade
        tradeRepository.delete(trade);
    }
}
