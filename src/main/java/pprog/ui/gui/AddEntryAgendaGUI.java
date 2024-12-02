package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.AddEntryAgendaController;
import pprog.domain.Task;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for the Add Entry Agenda GUI.
 */
public class AddEntryAgendaGUI implements Initializable {

    @FXML
    private TextField dateField;
    @FXML
    private TextField taskField;

    private final AddEntryAgendaController controller;

    /**
     * Constructs an AddEntryAgendaGUI object and initializes the controller.
     */
    public AddEntryAgendaGUI() {
        controller = new AddEntryAgendaController();
    }

    /**
     * Initializes the controller class. This method is automatically called after the FXML file has been loaded.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization required
    }

    /**
     * Handles the action when the submit button is clicked.
     * Validates the input, parses the date and task index, and adds the entry to the agenda.
     */
    @FXML
    private void handleSubmitButtonAction() {
        String dateText = dateField.getText().trim();
        String taskText = taskField.getText();

        if (dateText.isEmpty() || taskText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            date = dateFormat.parse(dateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        int taskIndex;
        try {
            taskIndex = Integer.parseInt(taskText);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers.");
            return;
        }

        if (!isValidTask(taskIndex)) {
            return;
        }

        String result = controller.addEntryAgenda(date, taskIndex);
        if (result == null) {
            showSuccess("Entry successfully added!\n\n" + controller.getEntryAdded());
            changeScene((Stage) dateField.getScene().getWindow(), "/fxml/AddEntryAgenda.fxml");
        } else {
            showAlert(result + "\n\nEntry not added!");
        }
    }

    /**
     * Checks if the given task index is valid.
     *
     * @param index The index of the task to be validated.
     * @return True if the task index is valid, false otherwise.
     */
    private boolean isValidTask(int index) {
        if (index < 1 || index > controller.getTasksList().size()) {
            showAlert("Invalid input. Please choose a valid option.");
            return false;
        }
        return true;
    }

    /**
     * Handles the action when the consult green spaces button is clicked.
     * Displays a list of tasks in a new alert dialog.
     */
    @FXML
    private void handleConsultGreenSpacesButtonAction() {
        List<Task> tasks = controller.getTasksList();
        if (tasks.isEmpty()) {
            showAlert("To-Do List is empty!");
        } else {
            StringBuilder sb = new StringBuilder("To-Do List:\n\n");
            int counter = 1;
            for (Task task : tasks) {
                sb.append(counter).append(":\n").append(task).append("\n\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    /**
     * Handles the action when the return button is clicked.
     * Changes the scene back to the Green Spaces Manager.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) dateField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
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
        alert.setTitle("To-Do List");
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
     * @param resourceName The FXML resource name to load.
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
