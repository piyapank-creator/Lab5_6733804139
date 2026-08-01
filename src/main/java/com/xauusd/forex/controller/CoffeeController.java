package com.xauusd.forex.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.xauusd.forex.service.CoffeeService;
import com.xauusd.forex.model.Coffee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RequestMapping("/coffees")
@RestController
public class CoffeeController{

    private final CoffeeService coffeeService;

    public CoffeeController() {
        coffeeService = new CoffeeService();
    }

    @GetMapping
    public Map<String, Object>  getAll() {
       return Map.of("Coffee",coffeeService.getAllCoffee());
    }

    @PostMapping
    public void  AddCoffee(@RequestBody Coffee cf) {
       coffeeService.AddCoffee(cf);
    }

      @GetMapping("/{id}")
    public Map<String, Object>  getCoffeeById(@PathVariable int id) {
       return Map.of("Coffee",coffeeService.getCoffeeById(id));
    }

    @PutMapping("/{id}")
    public void  UpdateCoffee(@RequestBody Coffee cf) {
       coffeeService.UpdateCoffeeById(cf);
    }

    @DeleteMapping("/{id}")
    public void DeleteCoffee(@PathVariable int id){
        coffeeService.DeleteCoffeeById(id);
    }

    @GetMapping("/search/{cfName}")
    public Map<String, Object>  getCoffeeByName(@PathVariable String cfName) {
       return Map.of("Coffee",coffeeService.getCoffeeByName(cfName));
    }
}
