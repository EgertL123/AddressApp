module com.addressapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.addressapp to javafx.fxml;
    exports com.addressapp;
}