package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmationController {

    @FXML
    private Button mainMenuButton;

    @FXML
    void handleMainMenuButtonAction(ActionEvent event) {
        openMainMenu(event);
    }
    
    @FXML
    private void openMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/MainMenu.fxml"));
            Stage stage = (Stage) mainMenuButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
