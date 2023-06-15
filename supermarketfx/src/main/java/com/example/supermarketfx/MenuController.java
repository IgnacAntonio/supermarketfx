package com.example.supermarketfx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class MenuController {

    private Scene scene;
    private Stage stage;
    @FXML
    protected ImageView logo = new ImageView();
    @FXML
    protected Button logout;

    public MenuController() {
        //connectToDatabase();
        Image image = new Image("resources/com/example/supermarketfx/images/logo.png");
        logo.setImage(image);
        logo.setCache(true);
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
    @FXML
    public void onLogoutButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)logout.getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
