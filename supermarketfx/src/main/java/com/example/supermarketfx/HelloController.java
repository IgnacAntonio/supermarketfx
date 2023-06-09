package com.example.supermarketfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    protected void onLoginButtonClick() {
        String user = userName.getText();
        String password = pwd.getText();
        if(validLogin(user, password)) {
            switchScene("menu-view.fxml");
        }
    }

    public boolean validLogin(String user, String password) {
        boolean login = false;
        if(user.equals("antonio") && password.equals("123")) {
            login = true;
        }
        return login;
    }

    public void switchScene(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
        stage.show();
    }
}