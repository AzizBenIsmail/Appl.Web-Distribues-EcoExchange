package com.trade.microservicetrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public Trade AddTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade updateTrade(int id, Trade newTrade) {

        if (tradeRepository.findById(id).isPresent()) {
            Trade existingTrade = tradeRepository.findById(id).get();
            existingTrade.setStatus(newTrade.getStatus());
            existingTrade.setProposalDate(newTrade.getProposalDate());

            return tradeRepository.save(existingTrade);
        } else
            return null;
    }

    public String deleteTrade(int id) {
        if (tradeRepository.findById(id).isPresent()) {
            tradeRepository.deleteById(id);
            return "Trade Deleted";
        } else
            return "Item non supprimé";
    }

    public List<Trade> getAllTrade() {
        return tradeRepository.findAll();
    }
}
