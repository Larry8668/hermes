package com.example.hermes.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;
// Assuming Stock and StockRepository are defined in your project
import com.example.hermes.Stock.Stock;
import com.example.hermes.Stock.StockRepository;

@Service
public class StockUpdater {
    @Autowired
    private StockRepository stockRepository; // Assuming you have a JPA repository for Stock

    @Scheduled(fixedRate = 1000) // Update every 5 seconds
    public void updateStockPrices() {
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            Random random = new Random();
            double randomChange = random.nextDouble(); // Generates a random double between 0 and 1
            double newPrice = stock.getPrice() + (random.nextBoolean() ? randomChange : -randomChange);


            BigDecimal bd = new BigDecimal(newPrice).setScale(4, RoundingMode.HALF_UP);
            double truncatedPrice = bd.doubleValue();
            System.out.println(stock.getName() + "--" + truncatedPrice + "--" + stock.getSymbol());
            stock.setPrice(truncatedPrice);
            stockRepository.save(stock);
        }
    }
}
