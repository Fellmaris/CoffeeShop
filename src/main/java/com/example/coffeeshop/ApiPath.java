package com.example.coffeeshop;

public interface ApiPath {
    String NAME_VARIABLE = "name";

    String COFFEE = "/coffee";
    String COFFEE_BY_NAME = "/{" + NAME_VARIABLE + "}";
}
