module com.example.bankmortgage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankmortgage to javafx.fxml;
    exports com.example.bankmortgage;
}