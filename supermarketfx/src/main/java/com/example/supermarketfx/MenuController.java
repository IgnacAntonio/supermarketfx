package com.example.supermarketfx;

import com.example.supermarketfx.Classes.Supermarket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class MenuController {

    private static Supermarket supermarket = new Supermarket();
    private static Connection connection = null;
    private Scene scene;
    private Stage stage;
    @FXML
    protected ImageView logo = new ImageView();
    @FXML
    protected Button logout;

    @FXML
    protected Button addProductButton;

    @FXML
    protected Button shopButton;

    public MenuController() {
        connectToDatabase();
    }

    public static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:15210/XEPDB1",
                    "supermarket", "yugo"
            );
            supermarket.getAllProductsFromDataBase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addProductButtonClick() throws SQLException, IOException {
        connection.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-product-view.fxml"));
        stage = (Stage) addProductButton.getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onLogoutButtonClick() throws IOException, SQLException {
        connection.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) logout.getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
