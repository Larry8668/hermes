package com.example.hermes.Stock;

import com.example.hermes.Stock.*;
import com.example.hermes.Stock.StockFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockFactory stockFactory;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("stockindex.html");
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Stock createStock(@RequestParam String symbol, @RequestParam String name, @RequestParam double price) {
        Stock newStock = stockFactory.createStock(symbol, name, price);
        return stockRepository.save(newStock);
    }

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stock.setName(stockDetails.getName());
            stock.setPrice(stockDetails.getPrice());
            stock.setSymbol(stockDetails.getSymbol());
            stockRepository.save(stock);
        }
        return stock;
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockRepository.deleteById(id);
    }
}
