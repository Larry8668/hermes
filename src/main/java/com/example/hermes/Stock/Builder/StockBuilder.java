package com.example.hermes.Stock.Builder;

import com.example.hermes.Stock.Model.Stock;

public interface StockBuilder {
    StockBuilder setName(String name);

    StockBuilder setType(String type);

    StockBuilder setPrice(Double price);

    Stock build();
}
