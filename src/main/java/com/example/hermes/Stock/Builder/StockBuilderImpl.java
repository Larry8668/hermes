package com.example.hermes.Stock.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hermes.Stock.Model.Stock;
import com.example.hermes.Stock.Model.StockRepository;

@Component
public class StockBuilderImpl implements StockBuilder {
    @Autowired
    StockRepository stockRepository;

    public StockBuilderImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    StockBuilderImpl(){
        
    }

    private String name;
    private String type;
    private Double price;

    public StockBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    public StockBuilderImpl setType(String type) {
        this.type = type;
        return this;
    }

    public StockBuilderImpl setPrice(Double price) {
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
