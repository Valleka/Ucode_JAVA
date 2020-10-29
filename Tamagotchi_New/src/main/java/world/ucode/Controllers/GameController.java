package world.ucode.Controllers;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

import world.ucode.Interfaces.InterPets;
import world.ucode.Timer;
import world.ucode.Main;
import world.ucode.UsersDB;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
//import java.util.Timer;

public class GameController implements Initializable, InterPets {
    public static double health = 0.9;
    public static double eat = 0.8;
    public static double sleep = 0.7;
    public static double shower = 0.6;
    public static double play = 0.5;
    private UsersDB db = new UsersDB();


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

    public String petName;

    @FXML
    public ImageView img;

    @FXML
    public void setImage(Image image, String name) {
        img.setImage(image);
        this.petName = name;
        if (Main.state == Main.States.Game) {
            Main.currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    try {
                        db.updateTable(petName);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
        }
        else {
            System.exit(0);
        }

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
        health += 0.09;
        if (health >= 1) {
            return;
        }
        healthBar.setProgress(health);

    }

    @FXML
    @Override
    public void feed() {
        eat += 0.09;
        eatBar.setProgress(eat);
    }

    @FXML
    @Override
    public void putToBad() {
        sleep += 0.09;
        sleepBar.setProgress(sleep);

    }

    @FXML
    @Override
    public void wash() {
        shower += 0.09;
        showerBar.setProgress(shower);
    }

    @FXML
    @Override
    public void play() {
        play +=0.09;
        playBar.setProgress(play);
    }

    public void setProgressBars(double health, double eat, double sleep, double shower, double play) {
        healthBar.setProgress(health);
        eatBar.setProgress(eat);
        sleepBar.setProgress(sleep);
        showerBar.setProgress(shower);
        playBar.setProgress(play);
    }


}


