package com.example.hermes.Stock.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hermes.Stock.Builder.StockBuilder;
import com.example.hermes.Stock.Model.Stock;

@Service
public class CustomStockBuilder implements StockFactory {
    
    @Autowired
    private final StockBuilder stockBuilder;

    public CustomStockBuilder(StockBuilder stockBuilder){
        this.stockBuilder=stockBuilder;
    }
    @Override
    public Stock createTechStock(String name) {
        return null;
    }
    
    @Override
    public Stock createFinStock(String name){
        return null;
    }
    
    @Override
    public Stock createPharmaStock(String name){
        return null;
    }
    
    private Stock buildStock(String name, String type, Double price) {
        return stockBuilder
                .setName(name)
                .setType(type)
                .setPrice(price)
                .build();
    }
    @Override
    public Stock createCustomStock(String name, String type, Double price){
        return buildStock(name, type, price);
    }
}
