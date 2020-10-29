package world.ucode;

import world.ucode.Controllers.GameController;
import world.ucode.Controllers.PreviewController;

import java.sql.*;


public class UsersDB {
    private static Connection connect;
    private static Statement statem;
    private static ResultSet res;
    private boolean userExist = false;

    public void getConnection(String name) throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:TamagotchiDB.s3db");
        statem = connect.createStatement();
        checkUser(name);
    }

    public void createTable(String name) {
        System.out.println();
        PreviewController checkPet = Main.loader2.getController();
        System.out.println("Wooooooooooof"); //нужно будет закоментить это

        try {
            statem.execute("insert into users('name', 'heals', 'eat', 'sleep', 'shower', 'play', 'pet_num') values('"+ name +"', 0, 0, 0, 0, 0, '" + checkPet.index +"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void checkUser(String name) throws SQLException {
        res = statem.executeQuery("select * from users");
        int ind = 0;

        while (res.next()) {
            ind++;
            if (name.equals(res.getString("name"))) {
                getData(name);
                return;
            }
        }
        createTable(name);
    }

    public void updateTable(String name) throws SQLException {
        String sql = "update users set heals = ?," + "eat = ?," + "sleep = ?, " + "shower = ?," + "play = ? where name = ?;";
        if (GameController.health >= 0 && GameController.eat >= 0 && GameController.play >= 0 && GameController.shower >= 0 && GameController.sleep >= 0) {
            PreparedStatement prepStat = connect.prepareStatement(sql);
            prepStat.setString(6, name);
            prepStat.setDouble(1, GameController.health);
            prepStat.setDouble(2, GameController.eat);
            prepStat.setDouble(3, GameController.sleep);
            prepStat.setDouble(4, GameController.shower);
            prepStat.setDouble(5, GameController.play);
            prepStat.executeUpdate();
        }
        else {
            System.out.println("Loos Data");
            return;
        }
    }

    public void getData(String name) throws  SQLException {
        String sql = "select * from users where name = '" + name + "';";
        res = statem.executeQuery(sql);
        GameController.health = res.getDouble("heals");
        GameController.eat = res.getDouble("eat");
        GameController.sleep = res.getDouble("sleep");
        GameController.shower = res.getDouble("shower");
        GameController.play = res.getDouble("play");

        GameController game = Main.loader3.getController();
        game.setProgressBars(GameController.health, GameController.eat, GameController.sleep, GameController.shower, GameController.play);
        game.img.setImage(PreviewController.imgs[res.getInt("pet_num")]);
        System.out.println(res.getInt("pet_num"));
    }
    public void deleteData(String name) throws SQLException {
        String sql = "delete from users where name ='" + name + "';";
        res = statem.executeQuery(sql);
    }

}
