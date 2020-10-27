package world.ucode.Controllers;

import javafx.fxml.FXML;
import world.ucode.Main;

public class EndGameControler {
    @FXML
    public void restartGame() throws Exception {
        Main main = new Main();
        Main.state = Main.States.Choose;
        main.start(Main.currentStage);
    }
    public void exit() {
        System.exit(0);
    }
}
