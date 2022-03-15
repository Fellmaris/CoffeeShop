package com.example.coffeeshop.repository;

import com.example.coffeeshop.data.Coffee;
import com.example.coffeeshop.provider.SessionConnectionProvider;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository /*extends AbstractRepository*/ {

    private SessionConnectionProvider connection;

    public CoffeeRepository() {
        this.connection = SessionConnectionProvider.getInstance();
    }

    public void createNewCoffee (Coffee coffee) {
        try {
            String query = "INSERT INTO COFFEE (NAME, PRICE) VALUES (\'" + coffee.getName() + "\', " + coffee.getPrice() + ")";
            connection.getSessionConnection().createStatement().execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        }

    public List<Coffee> getAllCoffee (){
        List <Coffee> coffeeList = new ArrayList<>();
        try {
           ResultSet resultSet = connection.getSessionConnection().createStatement().executeQuery("SELECT * FROM Coffee;");
           while (resultSet.next()){
               Coffee coffee = new Coffee(resultSet.getString("Name"), resultSet.getDouble("Price"));
               coffeeList.add(coffee);
           }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return coffeeList;
    }

    public void deleteCoffee (String coffee){
        try {
            String query = "DELETE FROM COFFEE WHERE Name=\'" + coffee + "\';";
            connection.getSessionConnection().createStatement().execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCoffee(Coffee coffee, String coffeeToUpdate){
        try {
            String query = "UPDATE COFFEE SET name = \'" + coffee.getName() + "\', price = " + coffee.getPrice() + " WHERE name = \'" + coffeeToUpdate + "\';";
            connection.getSessionConnection().createStatement().execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
