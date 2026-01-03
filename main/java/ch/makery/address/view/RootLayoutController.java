package ch.makery.address.view;

import ch.makery.address.MainApp;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 */
public class RootLayoutController {

    private Stage primaryStage;
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param primaryStage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleClose() {
        System.exit(0);
    }

    /**
     * Opens the statistics view.
     */
    @FXML
    private void handleShowStatistics() {
        mainApp.showStatistics();
    }
}