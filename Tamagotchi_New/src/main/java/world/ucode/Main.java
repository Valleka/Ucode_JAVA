package world.ucode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static FXMLLoader loader;
    public static FXMLLoader loader2;
    public static FXMLLoader loader3;
    public static FXMLLoader loader4;
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
                root = loader.load();
                break;
            case Choose:
                loader2 = new FXMLLoader(getClass().getResource("/Second_Scene.fxml"));
                root = loader2.load();
                break;
            case Game:
                loader3 = new FXMLLoader(getClass().getResource("/GameScene.fxml"));
                root = loader3.load();
                break;
            case End:
                loader4 = new FXMLLoader(getClass().getResource("/EngGameScene.fxml"));
                root = loader4.load();
                break;
            default:
                return;
        }
        currentStage = primaryStage;
        currentStage.setScene(new Scene(root));
        currentStage.setMinWidth(800);
        currentStage.setMinHeight(600);
        currentStage.setResizable(true);
        currentStage.setTitle("Tamagotchi");
        currentStage.show();
    }

    public static void main (String[] args) {
        Application.launch(args);
    }
}
