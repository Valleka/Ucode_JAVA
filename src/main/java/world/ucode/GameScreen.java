package world.ucode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1f;
    private float x = 0;
    private float y = 0;
    private float speedY = 0;


    private Thread thread;

    public GameScreen() {

        thread = new Thread(this);
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                speedY += GRAVITY;
                y += speedY;
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white); //цвет бэкграунда
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);//цвет квадрата
        g.drawRect((int) x, (int) y,100,100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        speedY = -4;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }

}
