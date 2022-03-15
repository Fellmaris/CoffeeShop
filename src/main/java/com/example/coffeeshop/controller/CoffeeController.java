package com.example.coffeeshop.controller;

import static com.example.coffeeshop.ApiPath.*;

import com.example.coffeeshop.data.Coffee;
import com.example.coffeeshop.service.CoffeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(COFFEE)
public class CoffeeController {
    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @GetMapping ()
    public String getAllCoffee(Model model) {
        model.addAttribute("allCoffee" , service.getAllCoffee());
        return "allCoffee";
    }

    @GetMapping("/create")
    public String loadCoffeeForm (Model model) {
        model.addAttribute("coffee", new Coffee());
        return "coffee";
    }

    @PostMapping("/create")
    public String createCoffee (Coffee coffee, Model model ){
        model.addAttribute("coffee", new Coffee());
        model.addAttribute("success", "Coffee created successfully");
        service.createCoffee(coffee);
        return "coffee";
    }

    @DeleteMapping("/delete")
    public String deleteCoffee (@RequestParam String coffee, Model model) {
        service.deleteCoffee(coffee);
        model.addAttribute("allCoffee", service.getAllCoffee());
        return "redirect:/allCoffee";
    }

    @GetMapping("/update")
    public String loadUpdateForm (@RequestParam String name, Model model) {
        model.addAttribute("coffee", service.getCoffee(name));
        return "coffee";
    }

    @PostMapping("/update" + COFFEE_BY_NAME)
    public String updateCoffee (@PathVariable(NAME_VARIABLE) String name, Coffee coffee, Model model){
        service.updateCoffee(coffee, name);
        model.addAttribute("allCoffee", service.getAllCoffee());
        return "redirect:/allCoffee";
    }
}
