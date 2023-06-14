module com.example.supermarketfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supermarketfx to javafx.fxml;
    exports com.example.supermarketfx;
}