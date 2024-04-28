package com.example.hermes.StockView.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.hermes.Stock.Model.Stock;
import com.example.hermes.Stock.Model.StockRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StockViewController {
    @Autowired
    private final StockRepository stockRepository;

    public StockViewController(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @GetMapping("/stockList")
    public ModelAndView stockList(Model model) {
        List<Stock> stocks = stockRepository.findAll();
        model.addAttribute(("stocks"), stocks);        
        return new ModelAndView("stock-view.html");
    }
    

}
