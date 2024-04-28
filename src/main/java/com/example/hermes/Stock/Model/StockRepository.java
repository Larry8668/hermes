package com.example.hermes.Stock.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    
}
