package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import world.ucode.Main;
import world.ucode.UsersDB;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EndGameControler implements Initializable {
    @FXML
    public void restartGame() throws Exception {
        Main main = new Main();
        Main.state = Main.States.Choose;
        main.start(Main.currentStage);
    }
    public void exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsersDB db = new UsersDB();
        GameController controller = Main.loader3.getController();
        try {
            db.deleteData(controller.petName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
