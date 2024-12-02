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

public class GreenSpaceManagerGUI implements Initializable {

    private final AuthenticationRepository authenticationRepository= Repositories.getInstance().getAuthenticationRepository();

    @FXML
    private Button btnRegisterGreenSpace;
    @FXML
    private Button btnAddEntryToDoList;
    @FXML
    private Button btnAddEntryAgenda;
    @FXML
    private Button btnAssignTeam;
    @FXML
    private Button btnPostponeEntry;
    @FXML
    private Button btnCancelEntry;
    @FXML
    private Button btnAssignVehicles;
    @FXML
    private Button btnListManagedGreenSpaces;
    @FXML
    private Button btnLogOut;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Performs the logout action.
     *
     * @param actionEvent The ActionEvent triggered when the logout button is clicked.
     */
    public void logOutAction(ActionEvent actionEvent) {
        authenticationRepository.doLogout();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setTitle("Login");
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

    /**
     * Changes the scene to the register green space scene.
     *
     * @param actionEvent The ActionEvent triggered when the register green space button is clicked.
     */
    public void registerGreenSpace(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/RegisterGreenSpace.fxml",true);
    }

    /**
     * Changes the scene to the add entry to to-do list scene.
     *
     * @param actionEvent The ActionEvent triggered when the add entry to to-do list button is clicked.
     */
    public void addEntryToDoList(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage, "/fxml/AddTaskToDoList.fxml",true);
    }

    /**
     * Changes the scene to the add entry to agenda scene.
     *
     * @param actionEvent The ActionEvent triggered when the add entry to agenda button is clicked.
     */
    public void addEntryAgenda(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AddEntryAgenda.fxml",true);
    }

    /**
     * Changes the scene to the assign team scene.
     *
     * @param actionEvent The ActionEvent triggered when the assign team button is clicked.
     */
    public void assignTeam(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AssignTeam.fxml",true);
    }

    /**
     * Changes the scene to the postpone entry scene.
     *
     * @param actionEvent The ActionEvent triggered when the postpone entry button is clicked.
     */
    public void postponeEntry(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/PostponeEntry.fxml",true);
    }

    /**
     * Changes the scene to the cancel entry scene.
     *
     * @param actionEvent The ActionEvent triggered when the cancel entry button is clicked.
     */
    public void cancelEntry(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/CancelEntry.fxml",true);
    }

    /**
     * Changes the scene to the assign vehicles scene.
     *
     * @param actionEvent The ActionEvent triggered when the assign vehicles button is clicked.
     */
    public void assignVehicles(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AssignVehicles.fxml",true);
    }

    /**
     * Changes the scene to the list managed green spaces scene.
     *
     * @param actionEvent The ActionEvent triggered when the list managed green spaces button is clicked.
     */
    public void listManagedGreenSpaces(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/ListGreenSpacesByGSM.fxml",true);
    }

    /**
     * Changes the scene of the stage.
     *
     * @param stage      The stage to which the scene will be set.
     * @param resourceName The resource name of the FXML file.
     * @param resizable  A boolean value indicating whether the stage is resizable or not.
     */
    public void changeScene(Stage stage, String resourceName,Boolean resizable){

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
