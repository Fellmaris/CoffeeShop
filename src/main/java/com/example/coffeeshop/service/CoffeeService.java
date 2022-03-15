package com.example.coffeeshop.service;

import com.example.coffeeshop.data.Coffee;
import com.example.coffeeshop.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    private final CoffeeRepository repository;

    public CoffeeService (CoffeeRepository repository) {this.repository = repository;}

    public List<Coffee> getAllCoffee () { return repository.getAllCoffee();}

    public void createCoffee (Coffee coffee) {repository.createNewCoffee(coffee);}

    public void deleteCoffee (String coffee) {repository.deleteCoffee(coffee);}

    public void updateCoffee (Coffee coffee, String coffeeToUpdate) {repository.updateCoffee(coffee, coffeeToUpdate);}

    public Coffee getCoffee (String name) {return repository.getCoffee(name);}
}
