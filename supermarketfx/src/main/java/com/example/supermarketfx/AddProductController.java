package com.example.supermarketfx;

import com.example.supermarketfx.Classes.Barcode;
import com.example.supermarketfx.Classes.FoodProduct;
import com.example.supermarketfx.Classes.NonFoodProduct;
import com.example.supermarketfx.Classes.Supermarket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddProductController {

    private Connection connection = null;
    private static Supermarket supermarket = new Supermarket();
    private Scene scene;
    private Stage stage;

    @FXML
    protected TextField productName;
    @FXML
    protected TextField productPrice;
    @FXML
    protected TextField productQuantity;
    @FXML
    protected TextField productBarcode;
    @FXML
    protected Button addProductButton;
    @FXML
    protected Button generateBarcodeButton;
    @FXML
    protected CheckBox isFood;
    @FXML
    protected Button backButton;

    public AddProductController() {
        connectToDataBase();
    }
    public void connectToDataBase() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:15210/XEPDB1",
                    "supermarket", "yugo"
            );
            System.out.println("connected");
            supermarket.getAllProductsFromDataBase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onAddProductButtonClick() {
        String name = productName.getText();
        int price = Integer.parseInt(productPrice.getText());
        int quantity = Integer.parseInt(productQuantity.getText());
        int barcode = Integer.parseInt(productBarcode.getText());
        boolean food = isFood.isSelected();

        if (food) {
            FoodProduct product = new FoodProduct(name, price, quantity, barcode);
            if(supermarket.addProduct(product)) {
                supermarket.addProductToDataBase(connection, product);
            }
        } else {
            NonFoodProduct product = new NonFoodProduct(name, price, quantity, barcode);
            if(supermarket.addProduct(product)) {
                supermarket.addProductToDataBase(connection, product);
            }
        }
        productPrice.setText("");
        productQuantity.setText("");
        productName.setText("");
        productBarcode.setText("");
        isFood.setSelected(false);
    }
    @FXML
    public void onGenerateBarcodeButtonClick() {
        Barcode barcode = new Barcode();
        barcode.generateBarcode();
        productBarcode.setText(String.valueOf(barcode.getBarcode()));
    }

    @FXML
    public void onBackButtonClick() throws SQLException, IOException {
        connection.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        stage = (Stage)backButton.getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
