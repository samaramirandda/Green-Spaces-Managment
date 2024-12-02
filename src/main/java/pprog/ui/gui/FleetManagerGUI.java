package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.ui.console.RegisterCheckUpUI;
import pprog.ui.console.RegisterVehicleUI;
import pprog.ui.console.VehicleNeedingMaintenanceUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for FleetManager GUI.
 */
public class FleetManagerGUI implements Initializable {

    private final AuthenticationRepository authenticationRepository= Repositories.getInstance().getAuthenticationRepository();

    @FXML
    private Button btnRegisterVehicle;
    @FXML
    private Button btnVehiclesCheckUp;
    @FXML
    private Button btnListVehiclesNeedingCheckUp;
    @FXML
    private Button btnLogOut;


    /**
     * Initializes the FleetManager GUI.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Logs out the user and returns to the main menu.
     *
     * @param actionEvent The ActionEvent triggered when the log out button is clicked.
     */
    public void logOutAction(ActionEvent actionEvent) {
        authenticationRepository.doLogout();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

    /**
     * Changes the scene to the specified resource.
     *
     * @param stage      The Stage to which the scene will be set.
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


    /**
     * Handles the action of registering a new vehicle.
     *
     * @param actionEvent The ActionEvent triggered when the register vehicle button is clicked.
     */
    public void registerVehicle(ActionEvent actionEvent) {
        startingAlert();
        RegisterVehicleUI u = new RegisterVehicleUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();

    }

    /**
     * Handles the action of performing vehicle check-ups.
     *
     * @param actionEvent The ActionEvent triggered when the vehicles check-up button is clicked.
     */
    public void vehiclesCheckUp(ActionEvent actionEvent) {
        startingAlert();
        RegisterCheckUpUI u = new RegisterCheckUpUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    /**
     * Handles the action of listing vehicles needing check-up.
     *
     * @param actionEvent The ActionEvent triggered when the list vehicles needing check-up button is clicked.
     */
    public void listVehiclesNeedingCheckUp(ActionEvent actionEvent) {
        startingAlert();
        VehicleNeedingMaintenanceUI u = new VehicleNeedingMaintenanceUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    /**
     * Displays an alert indicating that the operation has completed.
     */
    public void completedAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Success");
        alert.setHeaderText(null);
        alert.setContentText("Console operation terminated");
        alert.showAndWait();

    }

    /**
     * Displays an alert indicating that the operation has started.
     */
    public void startingAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Console Operation");
        alert.setHeaderText(null);
        alert.setContentText("Console operation starting");
        alert.showAndWait();

    }

}
