package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.util.Map;
import java.util.HashMap;

/**
 * Controller for the statistics view. Displays various statistics about persons
 * in pie charts.
 */
public class YearsStatisticsController {

    @FXML
    private PieChart statisticsChart;

    private MainApp mainApp;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Chart will be updated when data is set
    }

    /**
     * Sets the main app reference and loads the statistics.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        updateStatistics();
    }

    public static void main(String[] args) {
    }

    /**
     * Updates the statistics chart with birth year distribution.
     */
    private void updateStatistics() {
        ObservableList<Person> personData = mainApp.getPersonData();

        // Create a map to count persons by birth year
        Map<Integer, Integer> yearCounts = new HashMap<>();

        for (Person person : personData) {
            if (person.getBirthday() != null) {
                int year = person.getBirthday().getYear();
                yearCounts.put(year, yearCounts.getOrDefault(year, 0) + 1);
            }
        }

        // Convert to PieChart data
        ObservableList<PieChart.Data> pieChartData = javafx.collections.FXCollections.observableArrayList();

        for (Map.Entry<Integer, Integer> entry : yearCounts.entrySet()) {
            pieChartData.add(new PieChart.Data("Year " + entry.getKey(), entry.getValue()));
        }

        if (pieChartData.isEmpty()) {
            pieChartData.add(new PieChart.Data("No Data", 1));
        }

        statisticsChart.setData(pieChartData);
        statisticsChart.setTitle("Birth Year Distribution");
    }
}