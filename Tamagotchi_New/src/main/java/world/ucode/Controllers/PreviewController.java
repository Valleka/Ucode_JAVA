package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class PreviewController implements Initializable {
    @FXML
    ImageView image;

    Image imgs[] = new Image[3];
    public int index = 0;
    @FXML
    public void clickedPrev() throws Exception {
        if (index == 0) {
            index = 2;
        }
        else {
            index -= 1;
        }
        image.setImage(imgs[index]);
    }
    @FXML
    public void clickedNext() throws Exception {
        if (index == 2) {
            index = 0;
        }
        else {
            index += 1;
        }
        image.setImage(imgs[index]);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgs[0] = new Image("/Jerry_pet.png");
        imgs[1] = new Image("/Tom_pet.png");
        imgs[2] = new Image("/Spike_pet.png");
    }
}
