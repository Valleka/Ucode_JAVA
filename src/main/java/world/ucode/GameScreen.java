package world.ucode;

import world.ucode.objectgame.Cactus;
import world.ucode.objectgame.Clouds;
import world.ucode.objectgame.Land;
import world.ucode.objectgame.MainCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 110; //в пикселях позиция земли

    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private Cactus cactus;

    public GameScreen() {
        //конструктор
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50); // сдвигаем дино правее от левого края окна
        land = new Land(this);
        clouds = new Clouds();
        cactus = new Cactus();
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                mainCharacter.update();
                land.update();
                clouds.update();//движение облаков
                cactus.update();; //движение кактусов
                //коллизия, остановка при столкновении с чем-то
                if (cactus.getBound().intersects(mainCharacter.getBound())) {
                    System.out.println("Get Collision");
                }
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7")); //цвет бэкграунда всего поля
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int)GROUNDY, getWidth(), (int) GROUNDY);
        clouds.draw(g);
        land.draw(g);
        mainCharacter.draw(g);
        cactus.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        mainCharacter.jump();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }

}
