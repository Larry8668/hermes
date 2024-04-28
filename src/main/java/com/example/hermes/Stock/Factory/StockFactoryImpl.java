package com.example.hermes.Stock.Factory;

import org.springframework.stereotype.Service;

import com.example.hermes.Stock.Model.Stock;
import com.example.hermes.Stock.Model.StockRepository;

@Service
public class StockFactoryImpl implements StockFactory {

    private final StockRepository stockRepository;

    public StockFactoryImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createTechStock(String name) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType("tech");
        stock.setPrice(150.0);
        return stockRepository.save(stock);
    }

    @Override
    public Stock createFinStock(String name) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType("fin");
        stock.setPrice(170.0);
        return stockRepository.save(stock);
    }

    @Override
    public Stock createPharmaStock(String name) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType("pharma");
        stock.setPrice(190.0);
        return stockRepository.save(stock);
    }

    @Override
    public Stock createCustomStock(String name, String type, Double price) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setType(type);
        stock.setPrice(price);
        return stockRepository.save(stock);
    }

    public Stock createStock(String name, String type, Double price){
        Stock stock;
        switch(type.toLowerCase()){
            case "tech": 
                stock = createTechStock(name);
                break;
            case "fin":
                stock = createFinStock(name);
                break;
            case "pharma": 
                stock = createPharmaStock(name);
                break;
            default: 
                stock = createCustomStock(name, type, price);
                break;            
        }
        return stock;
    }
}