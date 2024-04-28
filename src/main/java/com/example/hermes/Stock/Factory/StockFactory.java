package com.example.hermes.Stock.Factory;

import com.example.hermes.Stock.Model.Stock;

public interface StockFactory {
    Stock createTechStock(String name);

    Stock createFinStock(String name);

    Stock createPharmaStock(String name);

    Stock createCustomStock(String name, String type, Double price);

}
