package pprog.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import pprog.repository.Repositories;
import pprog.ui.Bootstrap;

import java.io.File;
import java.util.Optional;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenuScene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeApplication();
        });

        primaryStage.show();
    }

    private void closeApplication() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        File f = new File("src\\main\\resources\\config.properties.xml");
        Repositories.getInstance().loadSystemStateFromBinary(f);
        pprog.ui.Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        launch(args);

        Repositories.getInstance().saveSystemStateToBinary(f);
    }
}
