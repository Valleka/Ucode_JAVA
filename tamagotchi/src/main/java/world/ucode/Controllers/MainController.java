package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainController {
    @FXML
    ImageView image;

    @FXML
    public void clicked() {
        System.out.println("clicked");
        image.setImage(new Image("/bg_scene_2.jpg"));
    }
}
