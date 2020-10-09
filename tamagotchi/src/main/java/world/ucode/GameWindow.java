package world.ucode;

import javax.swing.*;

public class GameWindow extends JFrame {
    //private GameScreen gameScreen;

    public GameWindow() {
        super("Tanagotchi");
        setSize(800, 400);
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gameScreen = new GameScreen();

    }
}
