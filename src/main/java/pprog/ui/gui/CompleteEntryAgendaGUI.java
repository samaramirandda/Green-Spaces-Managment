package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pprog.controller.CompleteEntryAgendaController;
import pprog.domain.Entry;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for CompleteEntryAgenda GUI.
 */
public class CompleteEntryAgendaGUI implements Initializable {

    @FXML
    private TextField entryField;

    @FXML
    private Button returnBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private Button listEntriesBtn;

    private CompleteEntryAgendaController controller;

    /**
     * Initializes the CompleteEntryAgenda GUI.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Constructor for CompleteEntryAgendaGUI.
     */
    public CompleteEntryAgendaGUI() {
        controller = new CompleteEntryAgendaController();
    }

    /**
     * Loads the entries from the controller and displays them.
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
     * Handles the completion of an entry.
     */
    @FXML
    private void handleCompleteEntry() {
        String entryText = entryField.getText().trim();

        if (entryText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        int entryIndex;
        try {
            entryIndex = Integer.parseInt(entryText);
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for entry.");
            return;
        }

        List<Entry> entries = controller.getEntriesList();

        if (entryIndex < 1 || entryIndex > entries.size()) {
            showAlert("Invalid entry number.");
            return;
        }

        String result = controller.completeEntry(entryIndex);
        if (result == null) {
            showSuccess("Entry completed successfully!\n\n" + controller.getEntryComplete(entryIndex));
        } else {
            showAlert(result + "\n\nEntry not completed!");
        }
    }

    /**
     * Handles the return button action.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) entryField.getScene().getWindow(), "/fxml/Collaborator.fxml");
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
     * Displays a list alert with the given message.
     *
     * @param message The message to be displayed in the alert.
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
