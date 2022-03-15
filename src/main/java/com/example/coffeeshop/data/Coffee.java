package com.example.coffeeshop.data;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table (name = "Coffee")
public class Coffee {
    @Id
    @NotNull
    private  String name;
    @NotNull
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
