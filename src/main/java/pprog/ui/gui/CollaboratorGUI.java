package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for Collaborator GUI.
 */
public class CollaboratorGUI implements Initializable {

    private final AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

    @FXML
    private Button btnConsultAssignedTasks;
    @FXML
    private Button btnCompletionTask;
    @FXML
    private Button btnLogOut;

    /**
     * Initializes the Collaborator GUI.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Handles the action when the logout button is clicked.
     *
     * @param actionEvent The ActionEvent associated with the action.
     */
    public void logOutAction(ActionEvent actionEvent) {
        authenticationRepository.doLogout();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage, "/fxml/MainMenuScene.fxml", true);
    }

    /**
     * Handles the action when the consult assigned tasks button is clicked.
     *
     * @param actionEvent The ActionEvent associated with the action.
     */
    public void consultAssignedTasks(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage, "/fxml/ConsultAssignedTasks.fxml", true);
    }

    /**
     * Handles the action when the completion task button is clicked.
     *
     * @param actionEvent The ActionEvent associated with the action.
     */
    public void completionTask(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage, "/fxml/CompleteEntry.fxml", true);
    }

    /**
     * Changes the scene to the specified resource.
     *
     * @param stage       The Stage to which the scene will be set.
     * @param resourceName The resource name of the FXML file.
     * @param resizable   Indicates if the stage should be resizable.
     */
    public void changeScene(Stage stage, String resourceName, Boolean resizable) {

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
}
