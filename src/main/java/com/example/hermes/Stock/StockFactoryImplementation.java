package com.example.hermes.Stock;


import com.example.hermes.Stock.Stock;

import org.springframework.stereotype.Component;
import com.example.hermes.Stock.StockFactory;

@Component
public class StockFactoryImplementation implements StockFactory {

    @Override
    public Stock createStock(String symbol, String name, double price) {
        return new Stock(symbol, name, price);
    }
}
