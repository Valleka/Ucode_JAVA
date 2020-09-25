package world.ucode.objectgame;

import world.ucode.util.Animation;
import world.ucode.util.Resourse;

import java.awt.*;

import static world.ucode.GameScreen.GRAVITY;
import static world.ucode.GameScreen.GROUNDY;

public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterRun;


    public MainCharacter() {
        characterRun = new Animation(200);
        characterRun.addFrame(Resourse.getResourceImage("src/main/resources/main-character1.png"));
        characterRun.addFrame(Resourse.getResourceImage("src/main/resources/main-character2.png"));
    }

    public void update() {
        characterRun.update(); //код бега
        // это код линии для прыжков
        if (y >= GROUNDY - characterRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUNDY - characterRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);//цвет квадрата
        g.drawRect((int) x, (int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());
        g.drawImage(characterRun.getFrame(), (int) x, (int) y, null);
    }

    public  void jump() {
        speedY = -4;
        y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
