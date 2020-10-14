package world.ucode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public FXMLLoader loader;
    private Parent root;
    public Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loader = new FXMLLoader(getClass().getResource("/Scene_2.fxml"));
        root = loader.load();
        currentStage = primaryStage;
        currentStage.setScene(new Scene(root));
        currentStage.setMinWidth(800);
        currentStage.setMinHeight(600);
        currentStage.setResizable(false);
        currentStage.setTitle("Tamagotchi");
        currentStage.show();
    }

    public static void main (String[] args) {
        Application.launch(args);
    }
}
