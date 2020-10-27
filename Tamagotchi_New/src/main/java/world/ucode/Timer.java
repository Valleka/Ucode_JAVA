package world.ucode;

import javafx.animation.AnimationTimer;
import world.ucode.Controllers.GameController;

public class Timer extends AnimationTimer {

    @Override
    public void handle(long l) {
        try {
            progressHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void progressHandle() throws Exception {
        GameController game = Main.loader3.getController();
        if (game.eat <= 0 || game.health <= 0 || game.play <= 0 || game.shower <= 0 || game.sleep <= 0) {
            stop();
            Main main = new Main();
            Main.state = Main.States.End;
            main.start(Main.currentStage);
        }
        else {
            game.eat -= 0.0004;
            game.health -= 0.0003;
            game.play -= 0.0002;
            game.shower -= 0.0004;
            game.sleep -= 0.0003;
            game.eatBar.setProgress(game.eat);
            game.healthBar.setProgress(game.health);
            game.playBar.setProgress(game.play);
            game.showerBar.setProgress(game.shower);
            game.sleepBar.setProgress(game.sleep);
        }
    }
}
