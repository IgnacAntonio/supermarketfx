module com.example.supermarketfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supermarketfx to javafx.fxml;
    exports com.example.supermarketfx;
}