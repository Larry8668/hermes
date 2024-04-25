package com.example.hermes.Stock;

public class StockPriceNotificationService implements StockPriceObserver {
    @Override
    public void update(Stock stock) {
        System.out.println("Stock price changed: " + stock.getSymbol() + " - " + stock.getPrice());
        // Here you can add logic to send notifications, update databases, etc.
    }
}
