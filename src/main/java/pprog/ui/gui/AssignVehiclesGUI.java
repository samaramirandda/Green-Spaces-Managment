package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.AssignVehiclesController;
import pprog.domain.Entry;
import pprog.domain.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for the Assign Vehicles GUI.
 */
public class AssignVehiclesGUI implements Initializable {
    @FXML
    private TextField entryField;
    @FXML
    private TextField vehicleField;
    private final AssignVehiclesController controller;

    /**
     * Constructs an AssignVehiclesGUI object and initializes the controller.
     */
    public AssignVehiclesGUI() {
        controller = new AssignVehiclesController();
    }

    /**
     * Initializes the controller class. This method is automatically called after the FXML file has been loaded.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization required
    }

    /**
     * Loads the list of entries and displays them.
     */
    @FXML
    private void loadEntries() {
        List<Entry> entries = controller.getEntriesList();
        if (entries.isEmpty()) {
            showAlert("Entries list is empty!");
        } else {
            StringBuilder sb = new StringBuilder("Entries list:\n\n");
            int counter = 1;
            for (Entry entry : entries) {
                sb.append(counter).append(":\n").append(entry).append("\n\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    /**
     * Loads the list of vehicles and displays them.
     */
    @FXML
    private void loadVehicles() {
        List<Vehicle> vehicles = controller.getVehiclesList();
        if (vehicles.isEmpty()) {
            showAlert("Vehicles list is empty!");
        } else {
            StringBuilder sb = new StringBuilder("Vehicles list:\n\n");
            int counter = 1;
            for (Vehicle vehicle : vehicles) {
                sb.append(counter).append(":\n").append(vehicle).append("\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    /**
     * Handles the action when the assign vehicles button is clicked.
     * Assigns vehicles to an entry based on the user input.
     */
    @FXML
    private void handleAssignVehicles() {
        String taskText = entryField.getText().trim();
        String vehicleText = vehicleField.getText().trim();

        if (taskText.isEmpty() || vehicleText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        int entryIndex;
        try {
            entryIndex = Integer.parseInt(taskText);
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for entry.");
            return;
        }

        List<Entry> entries = controller.getEntriesList();

        if (entryIndex < 1 || entryIndex > entries.size()) {
            showAlert("Invalid entry number.");
            return;
        }

        List<String> vehicles = new ArrayList<>();
        String[] vehiclePlateNumbers = vehicleText.split(",");
        for (String plateNumber: vehiclePlateNumbers) {
            vehicles.add(plateNumber);
        }

        String result = controller.assignVehiclesToEntry(entryIndex, vehicles);

        if (result == null) {
            showSuccess("Vehicle(s) assigned successfully!\n\n" + controller.getEntryWithVehicles(entryIndex));
        } else {
            showAlert(result + "\n\nVehicle(s) not assigned!");
        }
    }

    /**
     * Handles the action when the return button is clicked.
     * Changes the scene back to the Green Spaces Manager.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) entryField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
    }

    /**
     * Displays an alert dialog with the given message.
     *
     * @param message The message to be displayed in the alert.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Displays a success dialog with the given message.
     *
     * @param message The message to be displayed in the success dialog.
     */
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Displays a list dialog with the given message.
     *
     * @param message The message to be displayed in the list dialog.
     */
    private void showList(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("List");
        alert.setHeaderText(null);
        TextArea textArea = new TextArea(message);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefHeight(400);
        scrollPane.setPrefWidth(600);
        scrollPane.setMaxHeight(600);
        alert.getDialogPane().setContent(scrollPane);
        alert.showAndWait();
    }

    /**
     * Changes the scene to the specified FXML resource.
     *
     * @param stage        The current stage.
     * @param resourceName The resource name of the FXML file.
     */
    private void changeScene(Stage stage, String resourceName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
