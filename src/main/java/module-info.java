module com.example.spormusabakatakipuygulamasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spormusabakatakipuygulamasi to javafx.fxml;
    exports com.example.spormusabakatakipuygulamasi;
}