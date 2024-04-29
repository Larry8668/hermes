package com.example.hermes.Stock.Factory;

import org.springframework.stereotype.Service;
import com.example.hermes.Stock.Model.Stock;

@Service
public class TechStockFactory implements StockFactory {

    @Override
    public Stock createTechStock(String name) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType("tech");
        stock.setPrice(150.0);
        return stock;
    }

    @Override
    public Stock createFinStock(String name){
        return null;
    }

    @Override
    public Stock createPharmaStock(String name){
        return null;
    }

    @Override
    public Stock createCustomStock(String name, String type, Double price){
        return null;
    }
}
