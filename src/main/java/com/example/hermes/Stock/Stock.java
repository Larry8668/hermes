package com.example.hermes.Stock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Transient;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String name;
    private double price;
    

    @Transient
    private List<StockPriceObserver> observers = new ArrayList<>();

    // Add the constructor that matches the parameters used in StockFactoryImplementation
    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    // Existing constructors, getters, and setters
    public Stock(){
        // This is an empty constructor, which is necessary for JPA
    }

    // Getters and setters
    public String getSymbol(){
        return this.symbol;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void addObserver(StockPriceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockPriceObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StockPriceObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers();
    }
}
