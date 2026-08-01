package com.xauusd.forex.service;

import com.xauusd.forex.model.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {
    private List<Coffee> ListCoffee = new ArrayList<>();
    
    public CoffeeService(){
        ListCoffee.add(new Coffee(1,"Late",35.0));
        ListCoffee.add(new Coffee(2,"matcha",50.0));
        ListCoffee.add(new Coffee(3,"Americano",40.0));
    }

    public List<Coffee> getAllCoffee(){
        return ListCoffee;
    }

    
    public void AddCoffee(Coffee cf){
        this.ListCoffee.add(cf);
    }

    public void UpdateCoffeeById(Coffee cf){
        for (int i = 0;i < ListCoffee.size(); i++){
            if (ListCoffee.get(i).getId() == cf.getId()){
                ListCoffee.set(i, cf);
            }
        }
    }

    public void DeleteCoffeeById(int id){
        ListCoffee.removeIf(self -> self.getId() == id);
    }

    public Coffee getCoffeeById(int Id){
        for (Coffee cf : ListCoffee){
            if (cf.getId() == Id){
                return cf;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee not found with id: " + Id);
    }

    public Coffee getCoffeeByName(String cfName){
        List<Coffee> result = new ArrayList<>();
        for (Coffee cf : ListCoffee){
            if (cf.getName().toLowerCase().contains(cfName.toLowerCase())){
                result.add(cf);
            }
        }
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee not found with name: " + cfName);
        }
        return result.get(0);
    }


}