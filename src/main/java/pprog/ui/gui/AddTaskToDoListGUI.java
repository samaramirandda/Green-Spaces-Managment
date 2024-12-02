package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.AddTaskToDoListController;
import pprog.domain.GreenSpace;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for the Add Task To-Do List GUI.
 */
public class AddTaskToDoListGUI implements Initializable {

    @FXML
    private TextField titleField;
    @FXML
    private TextField descriptionField;
    @FXML
    private ComboBox<String> degreeOfUrgencyComboBox;
    @FXML
    private TextField expectedDurationField;
    @FXML
    private ComboBox<String> taskTypeComboBox;
    @FXML
    private TextField greenSpaceField;

    private final AddTaskToDoListController controller;

    /**
     * Constructs an AddTaskToDoListGUI object and initializes the controller.
     */
    public AddTaskToDoListGUI() {
        controller = new AddTaskToDoListController();
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
     * Validates the input and adds the task to the to-do list.
     */
    @FXML
    private void handleSubmitButtonAction() {

        String title = titleField.getText().trim();
        String description = descriptionField.getText().trim();
        int degreeOfUrgencyIndex = degreeOfUrgencyComboBox.getSelectionModel().getSelectedIndex();
        String expectedDurationText = expectedDurationField.getText();
        int taskTypeIndex = taskTypeComboBox.getSelectionModel().getSelectedIndex();
        String greenSpace = greenSpaceField.getText();

        if (title.isEmpty() || description.isEmpty() || degreeOfUrgencyIndex == -1 || expectedDurationText.isEmpty() || taskTypeIndex == -1 || greenSpace.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        int degreeOfUrgency = degreeOfUrgencyIndex + 1;
        int taskType = taskTypeIndex + 1;

        int expectedDuration;
        try {
            expectedDuration = Integer.parseInt(expectedDurationText);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers.");
            return;
        }

        if (!isValidTitle(title) || !isValidDescription(description) || !isValidDegreeOfUrgency(degreeOfUrgency) || !isValidExpectedDuration(expectedDuration) || !isValidType(taskType) || !isValidGreenSpace(greenSpace)) {
            return;
        }

        String result = controller.addTaskToDoList(title, description, degreeOfUrgency, expectedDuration, taskType, greenSpace);
        if (result == null) {
            showSuccess("Task successfully added!\n\n" + controller.getTaskAdded());
            changeScene((Stage) titleField.getScene().getWindow(), "/fxml/AddTaskToDoList.fxml");
        } else {
            showAlert(result + "\n\nTask not added!");
        }
    }

    /**
     * Checks if the given title is valid.
     *
     * @param name The title to be validated.
     * @return True if the title is valid, false otherwise.
     */
    private boolean isValidTitle(String name) {
        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid title. Please enter a valid title.");
            return false;
        }
        return true;
    }

    /**
     * Checks if the given description is valid.
     *
     * @param description The description to be validated.
     * @return True if the description is valid, false otherwise.
     */
    private boolean isValidDescription(String description) {
        if (!description.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid description. Please enter a valid description.");
            return false;
        }
        return true;
    }

    /**
     * Checks if the given degree of urgency is valid.
     *
     * @param degreeOfUrgency The degree of urgency to be validated.
     * @return True if the degree of urgency is valid, false otherwise.
     */
    private boolean isValidDegreeOfUrgency(int degreeOfUrgency) {
        if (degreeOfUrgency < 1 || degreeOfUrgency > 3) {
            showAlert("Invalid input. Please choose a valid option (1, 2 or 3).");
            return false;
        }
        return true;
    }

    /**
     * Checks if the given expected duration is valid.
     *
     * @param duration The expected duration to be validated.
     * @return True if the expected duration is valid, false otherwise.
     */
    private boolean isValidExpectedDuration(double duration) {
        if (duration < 0) {
            showAlert("Invalid input. Please insert a valid duration (greater than 0).");
            return false;
        }
        return true;
    }

    /**
     * Checks if the given task type is valid.
     *
     * @param type The task type to be validated.
     * @return True if the task type is valid, false otherwise.
     */
    private boolean isValidType(int type) {
        if (type < 1 || type > 2) {
            showAlert("Invalid input. Please choose a valid option (1 or 2).");
            return false;
        }
        return true;
    }

    /**
     * Checks if the given green space is valid.
     *
     * @param greenSpace The green space to be validated.
     * @return True if the green space is valid, false otherwise.
     */
    private boolean isValidGreenSpace(String greenSpace) {
        if (!greenSpace.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid name. Please enter a valid name.");
            return false;
        }
        return true;
    }

    /**
     * Handles the action when the return button is clicked.
     * Changes the scene back to the Green Spaces Manager.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) titleField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
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
        alert.setTitle("Green Spaces");
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

    /**
     * Handles the action when the consult green spaces button is clicked.
     * Displays a list of green spaces in a new alert dialog.
     */
    @FXML
    private void handleConsultGreenSpacesButtonAction() {
        List<GreenSpace> greenSpaces = controller.getGreenSpacesList();
        if (greenSpaces.isEmpty()) {
            showAlert("No Green Spaces found!");
        } else {
            StringBuilder sb = new StringBuilder("List of green spaces:\n\n");
            int counter = 1;
            for (GreenSpace greenSpace : greenSpaces) {
                sb.append("Name:").append(greenSpace.getName()).append("\nManaged By: ").append(greenSpace.getGreenSpacesManager()).append("\n\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

}
