package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.Main;


public class MainController {
    @FXML
    ImageView image;

    @FXML
    public void clicked() throws Exception {
        Main main = new Main();
        Main.state = Main.States.Game;
        main.start(Main.currentStage);
    }
}
