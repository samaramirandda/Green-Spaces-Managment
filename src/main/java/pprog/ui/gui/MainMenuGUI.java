package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuGUI implements Initializable {

    public Button btnDoLogin;
    public Button btnDevTeam;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Changes the scene to the login scene.
     *
     * @param actionEvent The ActionEvent triggered when the login button is clicked.
     */
    public void changeToLoginScene(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Authentication.fxml"));
            Parent root = loader.load();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the scene to the development team scene.
     *
     * @param actionEvent The ActionEvent triggered when the development team button is clicked.
     */
    public void knowTheTeamAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DevTeam.fxml"));
            Parent root = loader.load();
            stage.setTitle("Development Team");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    public void completedAlert() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Operation Success");
//        alert.setHeaderText(null);
//        alert.setContentText("Console operation terminated");
//        alert.showAndWait();
//    }
//
//    public void startingAlert() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Console Operation");
//        alert.setHeaderText(null);
//        alert.setContentText("Console operation starting");
//        alert.showAndWait();
//    }
}
