package com.example.hermes.Stock.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hermes.Stock.Model.Stock;
import com.example.hermes.Stock.Model.StockRepository;

@Component
public class StockBuilder {
    @Autowired
    StockRepository stockRepository;

    public StockBuilder(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    StockBuilder(){
        
    }

    private String name;
    private String type;
    private Double price;

    public StockBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StockBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public StockBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Stock build() {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType(type);
        stock.setPrice(price);
        return stockRepository.save(stock);
    }
}
