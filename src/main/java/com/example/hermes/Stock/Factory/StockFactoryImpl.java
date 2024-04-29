package com.example.hermes.Stock.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hermes.Stock.Builder.StockBuilder;
import com.example.hermes.Stock.Model.Stock;
import com.example.hermes.Stock.Model.StockRepository;

@Service
public class StockFactoryImpl {

    private final StockRepository stockRepository;

    @Autowired
    private CustomStockBuilder customStockBuilder; 


    public StockFactoryImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    

    StockFactory techStockFactory = new TechStockFactory();
    StockFactory finFactory = new FinStockFactory();
    StockFactory pharmaFactory = new PharmaStockFactory();

    public Stock createStock(String name, String type, Double price) {
        Stock stock;
        switch (type.toLowerCase()) {
            case "tech":
                stock = stockRepository.save(techStockFactory.createTechStock(name));
                break;
            case "fin":
                stock = stockRepository.save(finFactory.createFinStock(name));
                break;
            case "pharma":
                stock = stockRepository.save(pharmaFactory.createPharmaStock(name));
                break;
            default:
                stock = customStockBuilder.createCustomStock(name, type, price);
                break;
        }
        return stock;
    }
}