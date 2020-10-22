package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    public ImageView img;

    public void setImage(Image image) {
        img.setImage(image);
    }
}
