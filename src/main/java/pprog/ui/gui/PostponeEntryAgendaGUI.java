package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.PostponeEntryAgendaController;
import pprog.domain.Entry;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PostponeEntryAgendaGUI implements Initializable {

    @FXML
    private TextField dateField;
    @FXML
    TextField entryField;
    @FXML
    Button returnBtn;
    @FXML
    Button submitBtn;
    @FXML
    Button listEntriesBtn;
    private final PostponeEntryAgendaController controller;

    public PostponeEntryAgendaGUI() {
        controller = new PostponeEntryAgendaController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Loads the list of entries.
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
                sb.append(counter).append(":\n").append(entry).append("\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    /**
     * Handles the action of assigning a team to an entry.
     */
    @FXML
    private void handleAssignTeam() {
        String taskText = entryField.getText().trim();
        String dateText = dateField.getText().trim();

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

        String result = controller.postponeEntry(entryIndex, date);
        if (result == null) {
            showSuccess("Entry postponed successfully!\n\n" + controller.getEntryPostpone(entryIndex));
        } else {
            showAlert(result + "\n\nEntry not postponed!");
        }
    }

    /**
     * Handles the action of returning to the previous scene.
     */
    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) entryField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
    }

    /**
     * Shows a warning alert.
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
     * Shows a success alert.
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
     * Shows a list of entries in a dialog.
     *
     * @param message The message to be displayed in the dialog.
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
     * @param stage        The current stage.
     * @param resourceName The resource name of the FXML file for the new scene.
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
