package com.example.coffeeshop.provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class SessionConnectionProvider {

    private static SessionConnectionProvider instance;
    private Connection connection;

    private SessionConnectionProvider(){
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            connection = DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/C:\\Databases\\COFFEESHOPDB.FDB",
                    "SYSDBA", "masterkey");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static SessionConnectionProvider getInstance(){
        if (instance == null){
            instance = new SessionConnectionProvider();
        }
        return instance;
    }

    public Connection getSessionConnection() {return connection;}


}
