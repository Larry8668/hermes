package com.example.hermes.Stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hermes.Stock.Factory.StockFactory;
import com.example.hermes.Stock.Factory.StockFactoryImpl;
import com.example.hermes.Stock.Model.Stock;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {

    @Autowired
    private final StockFactoryImpl stockFactoryImpl;

    public StockController(StockFactoryImpl stockFactoryImpl) {
        this.stockFactoryImpl = stockFactoryImpl;
    }

    @GetMapping("/factory")
    public ModelAndView getFactory(Model model) {
        return new ModelAndView("factory.html");
    }

    @PostMapping("/addStock")
    public String addStock(@RequestParam String name, @RequestParam String type, @RequestParam Double price, RedirectAttributes redirectAttributes) {
        stockFactoryImpl.createStock(name, type, price);
        redirectAttributes.addFlashAttribute("successMessage", "Stock added to Market");
        return "redirect:/factory";
    }
}
