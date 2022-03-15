package com.example.coffeeshop.controller;

import static com.example.coffeeshop.ApiPath.*;

import com.example.coffeeshop.data.Coffee;
import com.example.coffeeshop.service.CoffeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(COFFEE)
public class CoffeeController {
    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> getAllCoffee() {return service.getAllCoffee();}

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCoffee (@RequestBody Coffee coffee) { service.createCoffee(coffee);}

    @DeleteMapping(COFFEE_BY_NAME)
    public void deleteCoffee (@PathVariable (NAME_VARIABLE) String coffee) {service.deleteCoffee(coffee);}

    @PutMapping(value = COFFEE_BY_NAME, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct (@RequestBody Coffee coffee ,@PathVariable (NAME_VARIABLE) String coffeeToUpdate) {service.updateCoffee(coffee, coffeeToUpdate);}
}
