module ch.makery.address {
    requires javafx.controls;
    requires javafx.fxml;

    // Allow FXML to access controllers via reflection
    opens ch.makery.address.view to javafx.fxml;

    // Allow JavaFX properties & TableView reflection
    opens ch.makery.address.model to javafx.base;

    // Main application package
    exports ch.makery.address;
}
