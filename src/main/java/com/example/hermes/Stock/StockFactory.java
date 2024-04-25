package com.example.hermes.Stock;

public interface StockFactory {
    Stock createStock(String symbol, String name, double price);
}
