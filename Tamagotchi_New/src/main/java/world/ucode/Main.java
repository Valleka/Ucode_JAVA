package world.ucode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public FXMLLoader loader;
    private Parent root;
    public static Stage currentStage;

    public static enum States {
        Start,
        Choose,
        Game,
        End
    };
    public static States state = States.Start;
    @Override
    public void start(Stage primaryStage) throws Exception {
        switch (state) {
            case Start:
                loader = new FXMLLoader(getClass().getResource("/First_Scene.fxml"));
                break;
            case Game:
                loader = new FXMLLoader(getClass().getResource("/Second_Scene.fxml"));
                break;
            default:
                break;
        }

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
