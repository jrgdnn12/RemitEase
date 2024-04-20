package projectfiles.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RunApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomePage.fxml"));
            Parent root = loader.load();
            WelcomePageController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Welcome to RemitEase");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public static void main(String[] args) {
		launch(args);

	}

}
