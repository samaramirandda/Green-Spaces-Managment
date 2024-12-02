package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.CancelEntryAgendaController;
import pprog.domain.Entry;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for CancelEntryAgenda GUI.
 */
public class CancelEntryAgendaGUI implements Initializable {

    @FXML
    TextField entryField;
    @FXML
    Button returnBtn;
    @FXML
    Button submitBtn;
    @FXML
    Button listEntriesBtn;
    private final CancelEntryAgendaController controller;

    /**
     * Default constructor.
     */
    public CancelEntryAgendaGUI() {
        controller = new CancelEntryAgendaController();
    }

    /**
     * Initializes the controller class. This method is automatically called after the FXML file has been loaded.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization required
    }

    /**
     * Loads the entries.
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
     * Handles the action when the cancel entry button is clicked.
     */
    @FXML
    private void handleCancelEntry() {
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

        String result = controller.cancelEntry(entryIndex);
        if (result == null) {
            showSuccess("Entry canceled successfully!\n\n" + controller.getEntryCancel(entryIndex));
        } else {
            showAlert(result + "\n\nEntry not canceled!");
        }
    }

    /**
     * Handles the action when the return button is clicked.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) entryField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
    }

    /**
     * Shows a warning alert.
     *
     * @param message The message to be displayed.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Shows a success alert.
     *
     * @param message The message to be displayed.
     */
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Shows a list alert.
     *
     * @param message The message to be displayed.
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
     * Changes the scene.
     *
     * @param stage The stage to which the scene will be set.
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
