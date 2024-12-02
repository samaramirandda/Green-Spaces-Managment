package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for DevTeam GUI.
 */
public class DevTeamGUI implements Initializable {

    /**
     * Initializes the DevTeam GUI.
     *
     * @param location  The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Changes the scene to the specified resource.
     *
     * @param stage      The Stage to which the scene will be set.
     * @param resourceName The resource name of the FXML file.
     * @param resizable  A boolean value indicating whether the stage is resizable or not.
     */
    @FXML
    private void changeScene(Stage stage, String resourceName,Boolean resizable) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setResizable(resizable);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action to return to the main menu.
     *
     * @param actionEvent The ActionEvent triggered when the return button is clicked.
     */
    public void doReturnToMenuAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setTitle("Main Menu");
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

}
