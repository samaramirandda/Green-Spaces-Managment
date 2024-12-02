package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pprog.controller.ConsultTasksController;
import pprog.domain.Entry;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for ConsultAssignedTask GUI.
 */
public class ConsultAssignedTaskGUI implements Initializable {

    @FXML
    private TextField startDateField;

    @FXML
    private TextField endDateField;

    @FXML
    private Button submitBtn;

    @FXML
    private Button returnBtn;

    private ConsultTasksController controller;

    /**
     * Initializes the ConsultAssignedTask GUI.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Constructor for ConsultAssignedTaskGUI.
     */
    public ConsultAssignedTaskGUI() {
        controller = new ConsultTasksController();
    }

    /**
     * Loads the entries from the given list and returns a StringBuilder object.
     *
     * @param entries The list of entries to be loaded.
     * @return A StringBuilder object containing the loaded entries.
     */
    @FXML
    private StringBuilder loadEntries(List<Entry> entries) {
        StringBuilder sb = new StringBuilder("Tasks list:\n\n");
        int counter = 1;
        for (Entry entry : entries) {
            sb.append(counter).append(":\n").append(entry.getTask().getTitle()).append(" - ").append(entry.getStartingDate()).append("\n\n");
            counter++;
        }
        sb.toString();
        return sb;
    }

    /**
     * Handles the submission of the form.
     */
    @FXML
    private void handleSubmit() {
        String startDateText = startDateField.getText().trim();
        String endDateText = endDateField.getText().trim();

        if (startDateText.isEmpty() || endDateText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        Date startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            startDate = dateFormat.parse(startDateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        Date endDate;
        dateFormat.setLenient(false);
        try {
            endDate = dateFormat.parse(endDateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        List<Entry> result = controller.getTasksForCollaboratorBetweenDates(startDate, endDate);
        if (result != null) {
            showSuccess("\n" + loadEntries(result));
        } else {
            showAlert("No tasks were assigned to you during this period.");
        }
    }

    /**
     * Handles the return button action.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) startDateField.getScene().getWindow(), "/fxml/Collaborator.fxml");
    }

    /**
     * Displays a warning alert with the given message.
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
     * Displays a success alert with the given message.
     *
     * @param message The message to be displayed in the alert.
     */
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Changes the scene to the specified resource.
     *
     * @param stage       The Stage to which the scene will be set.
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
