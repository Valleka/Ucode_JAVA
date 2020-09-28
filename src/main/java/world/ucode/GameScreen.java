package world.ucode;

import world.ucode.objectgame.Clouds;
import world.ucode.objectgame.EnemiesManager;
import world.ucode.objectgame.Land;
import world.ucode.objectgame.MainCharacter;
import world.ucode.util.Resourse;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import static java.applet.Applet.newAudioClip;

public class GameScreen extends JPanel implements Runnable, KeyListener {
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 110; //в пикселях позиция земли

    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private EnemiesManager enemiesManager;
    private int score;

    private int gameState = GAME_FIRST_STATE;

    private BufferedImage imageGameOverText;
    private AudioClip scoreUpSound;
    public static AudioClip jumpSound;
    public static AudioClip SoundDead;

    public GameScreen() {
        //конструктор
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50); // сдвигаем дино правее от левого края окна
        mainCharacter.setY(60);// сдвигаем дино вниз на старте игры
        land = new Land(this);
        clouds = new Clouds();
        enemiesManager = new EnemiesManager(mainCharacter, this);
        imageGameOverText = Resourse.getResourceImage("src/main/resources/gameover_text.png");
        try {
            jumpSound = newAudioClip(new URL("file", "", "src/main/resources/jump.wav"));
            scoreUpSound = newAudioClip(new URL("file", "", "src/main/resources/scoreup.wav"));
            SoundDead = newAudioClip(new URL("file", "", "src/main/resources/dead.wav"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                mainCharacter.update();
                land.update();
                clouds.update();//движение облаков
                enemiesManager.update();
                if (!mainCharacter.getAlive()) {
                    gameState = GAME_OVER_STATE;
                }
                break;
        }
    }

    //плюсуем стату
    public void plusScore(int score) {
        this.score += score;
        scoreUpSound.play();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7")); //цвет бэкграунда всего поля
        g.fillRect(0, 0, getWidth(), getHeight());
//        g.setColor(Color.red);
//        g.drawLine(0, (int)GROUNDY, getWidth(), (int) GROUNDY);

        switch (gameState) {
            case GAME_FIRST_STATE:
                mainCharacter.draw(g);
                break;
            case GAME_PLAY_STATE:
                clouds.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                g.drawString("HI " + String.valueOf(score), 500, 20);
                break;
            case GAME_OVER_STATE:
                clouds.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                g.drawImage(imageGameOverText, 200, 30, null);
                break;
        }

    }

    private void resetGame() {
        mainCharacter.setAlive(true); //перезапускаем игру при нажатии на пробел
        mainCharacter.setX(50);
        mainCharacter.setY(60);
        enemiesManager.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE) {
                    gameState = GAME_PLAY_STATE;
                } else if (gameState == GAME_PLAY_STATE) {
                    mainCharacter.jump();
                } else if (gameState == GAME_OVER_STATE) {
                    resetGame(); //перезапускаем игру при нажатии пробела
                    gameState = GAME_PLAY_STATE;

                }
                break;
        }
    }

}
