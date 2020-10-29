package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.Main;
import world.ucode.UsersDB;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PreviewController implements Initializable {
    @FXML
    public ImageView image;
    @FXML
    public Button nextButton;
    @FXML
    public TextField name;

    public static final Image[] imgs = new Image[3];
    public static int index = 0;


    @FXML
    public void clickedPrev() {
        if (index == 0) {
            index = 2;
        }
        else {
            index -= 1;
        }
        image.setImage(imgs[index]);
    }

    @FXML
    public void clickedNext() {
        if (index == 2) {
            index = 0;
        }
        else {
            index += 1;
        }
        image.setImage(imgs[index]);
    }

    @FXML
    public void clickedSet() throws Exception {
        Main main = new Main();
        Main.state = Main.States.Game;
        main.start(Main.currentStage);
        GameController game = Main.loader3.getController();
        game.setImage(imgs[index], name.getText());
        save();
    }
    public void save() throws SQLException, ClassNotFoundException {
        String petName = name.getText();
        UsersDB data = new UsersDB();
        data.getConnection(petName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgs[0] = new Image("/Jerry_pet.png");
        imgs[1] = new Image("/Tom_pet.png");
        imgs[2] = new Image("/Spike_pet.png");
    }
}
