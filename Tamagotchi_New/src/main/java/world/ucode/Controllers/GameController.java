package world.ucode.Controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import world.ucode.Interfaces.InterPets;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class GameController implements Initializable, InterPets {
    public double health = 0.7;
    public double eat = 0.8;
    public double sleep = 0.5;
    public double shower = 0.5;
    public double play = 0.5;

    private AnimationTimer timer = new Timer();

    @FXML
    public ProgressBar healthBar;
    @FXML
    public ProgressBar eatBar;
    @FXML
    public ProgressBar sleepBar;
    @FXML
    public ProgressBar showerBar;
    @FXML
    public ProgressBar playBar;



    @FXML
    public ImageView img;
    public void setImage(Image image) {
        img.setImage(image);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        healthBar.setProgress(health);
        eatBar.setProgress(eat);
        sleepBar.setProgress(sleep);
        showerBar.setProgress(shower);
        playBar.setProgress(play);
        timer.start();
    }

    @FXML
    @Override
    public void toHealth() {
        health += 0.05;
        if (health >= 1) {
            return;
        }
        healthBar.setProgress(health);

    }

    @FXML
    @Override
    public void feed() {
        eat += 0.05;
        eatBar.setProgress(eat);
    }

    @FXML
    @Override
    public void putToBad() {
        sleep += 0.05;
        sleepBar.setProgress(sleep);

    }

    @FXML
    @Override
    public void wash() {
        shower += 0.05;
        showerBar.setProgress(shower);
    }

    @FXML
    @Override
    public void play() {
        play +=0.05;
        playBar.setProgress(play);
    }
}


