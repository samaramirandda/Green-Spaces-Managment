package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pprog.controller.authorization.AuthenticationController;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Controller class for the Authentication GUI.
 */
public class AuthenticationGUI implements Initializable {
    @FXML
    private CheckBox checkButton;
    @FXML
    private TextField txtShowPwd;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPwd;
    @FXML
    private Button btnReturn;
    @FXML
    private Button btnLogIn;

    private int maxAttemps = 3;
    private final AuthenticationController controller = new AuthenticationController();


    /**
     * Initializes the controller class. This method is automatically called after the FXML file has been loaded.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization required
    }

    /**
     * Handles the action when the login button is clicked.
     *
     * @param actionEvent The event representing the action.
     */
    public void doLoginActionButton(ActionEvent actionEvent) {
        boolean success = doLogin();

        if (success) {
            maxAttemps = 3;
            List<UserRoleDTO> roles = this.controller.getUserRoles();
            if ((roles == null) || (roles.isEmpty())) {
                System.out.println("No role assigned to user.");
            } else {
                UserRoleDTO role = roles.get(0);
                if (!Objects.isNull(role)) {
                    Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
                    switch (role.getDescription()) {
                        case AuthenticationController.ROLE_HRM:
                            stage.setTitle("Human Resources Manager Menu");
                            changeScene(stage, "/fxml/HumanResourcesManager.fxml", false);
                            break;
                        case AuthenticationController.ROLE_VFM:
                            stage.setTitle("Fleet Manager Menu");
                            changeScene(stage, "/fxml/FleetManager.fxml", false);
                            break;
                        case AuthenticationController.ROLE_GSM:
                            stage.setTitle("Green Space Manager Menu");
                            changeScene(stage, "/fxml/GreenSpacesManager.fxml", false);
                            break;
                        case AuthenticationController.ROLE_COLLABORATOR:
                            stage.setTitle("Collaborator Menu");
                            changeScene(stage, "/fxml/Collaborator.fxml", false);
                            break;
                    }
                } else {
                    System.out.println("No role selected.");
                }
            }
        } else {
            maxAttemps--;
            if (maxAttemps > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Credentials");
                alert.setHeaderText("Invalid Email and/or Password");
                alert.setContentText("You have " + maxAttemps + " attempts remaining");
                alert.showAndWait();
                txtPwd.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Max Attempts Reached");
                alert.setHeaderText("Maximum number of attempts reached");
                alert.setContentText("You will be redirected to the main menu");
                alert.showAndWait();
                closeLoginStage(actionEvent);
            }
        }
        //this.logout();
    }

    /**
     * Handles the action when the enter key is pressed.
     *
     * @param keyEvent The event representing the key press.
     * @throws IOException If an I/O error occurs.
     */
    public void doLoginActionKey(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            boolean success = doLogin();

            if (success) {
                maxAttemps = 3;
                List<UserRoleDTO> roles = this.controller.getUserRoles();
                if ((roles == null) || (roles.isEmpty())) {
                    System.out.println("No role assigned to user.");
                } else {
                    UserRoleDTO role = roles.get(0);
                    if (!Objects.isNull(role)) {
                        Stage stage = (Stage) ((Node) keyEvent.getTarget()).getScene().getWindow();
                        switch (role.getDescription()) {
                            case AuthenticationController.ROLE_HRM:
                                changeScene(stage, "/fxml/HumanResourcesManager.fxml", false);
                                break;
                            case AuthenticationController.ROLE_VFM:
                                changeScene(stage, "/fxml/FleetManager.fxml", false);
                                break;
                            case AuthenticationController.ROLE_GSM:
                                changeScene(stage, "/fxml/GreenSpacesManager.fxml", false);
                                break;
                            case AuthenticationController.ROLE_COLLABORATOR:
                                changeScene(stage, "/fxml/Collaborator.fxml", false);
                                break;
                        }
                    } else {
                        System.out.println("No role selected.");
                    }
                }
            } else {
                maxAttemps--;
                if (maxAttemps > 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Credentials");
                    alert.setHeaderText("Invalid Email and/or Password");
                    alert.setContentText("You have " + maxAttemps + " attempts remaining");
                    alert.showAndWait();
                    txtPwd.clear();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Max Attempts Reached");
                    alert.setHeaderText("Maximum number of attempts reached");
                    alert.setContentText("You will be redirected to the main menu");
                    alert.showAndWait();
                    closeLoginStage(keyEvent);
                }
            }
        }
    }

    /**
     * Closes the login stage.
     *
     * @param event The event representing the action.
     */
    private void closeLoginStage(Event event) {
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setTitle("Main Menu");
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

    /**
     * Performs the login operation.
     *
     * @return true if login is successful, otherwise false.
     */
    private boolean doLogin() {

        boolean success = false;
        String id = txtEmail.getText();
        String pwd = txtPwd.getText();

        try {
            success = controller.doLogin(id, pwd);

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Format");
            alert.setHeaderText("Invalid Format Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

        return success;
    }


    /**
     * Handles the action when the return to menu button is clicked.
     *
     * @param actionEvent The event representing the action.
     */
    public void doReturnToMenuAction(ActionEvent actionEvent) {
        closeLoginStage(actionEvent);
    }

    /**
     * Changes the scene.
     *
     * @param stage       The stage to which the scene will be set.
     * @param resourceName The resource name of the FXML file.
     * @param rezizeble   Whether the stage is resizable or not.
     */
    public void changeScene(Stage stage, String resourceName,Boolean rezizeble){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setResizable(rezizeble);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Handles the action when the Enter key is pressed during login.
     *
     * @param keyEvent The KeyEvent associated with the key press event.
     */
    public void darEnterLoginAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                doLoginActionKey(keyEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Unhides the password field when the checkButton is selected.
     * Binds the textProperty of txtShowPwd to the textProperty of txtPwd.
     * If the checkButton is not selected, hides the password field.
     *
     * @param actionEvent The ActionEvent associated with the action.
     */
    public void unHidePwdField(ActionEvent actionEvent) {
        if (checkButton.isSelected()){
            txtShowPwd.setVisible(true);
            txtPwd.setManaged(false);
            txtShowPwd.textProperty().bindBidirectional(txtPwd.textProperty());
        } else {
            txtShowPwd.setVisible(false);
            txtPwd.setManaged(true);
            txtShowPwd.textProperty().bindBidirectional(txtPwd.textProperty());
        }
    }

}
