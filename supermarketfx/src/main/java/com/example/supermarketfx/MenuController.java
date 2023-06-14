package com.example.supermarketfx;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;


import java.sql.*;

public class MenuController {

    @FXML
    private ImageView imageView;

    public MenuController() {

        connectToDatabase();
    }
    public void connectToDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:15210/XEPDB1",
                    "sys as sysdba", "Oraxe21"
            );
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
