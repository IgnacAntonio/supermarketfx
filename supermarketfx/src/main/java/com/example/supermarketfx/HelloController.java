package com.example.supermarketfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField userName;
    @FXML
    private TextField pwd;
    @FXML
    private Button loginButton;
    private Scene scene;
    private Stage stage;



    @FXML
    protected void onLoginButtonClick() throws IOException {
        String user = userName.getText();
        String password = pwd.getText();
        if(validLogin(user, password)) {
            switchScene("menu-view.fxml");
        }
    }

    public boolean validLogin(String user, String password) {
        return user.equals("antonio") && password.equals("123");
    }

    public void switchScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        stage = (Stage)loginButton.getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}