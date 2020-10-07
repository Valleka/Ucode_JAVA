package world.ucode.objectgame;

import world.ucode.GameScreen;
import world.ucode.util.Animation;
import world.ucode.util.Resourse;

import java.awt.*;

import static world.ucode.GameScreen.GRAVITY;
import static world.ucode.GameScreen.GROUNDY;

public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation downRunAnim;
    private Animation normalRun;
    private Rectangle rect;
    private boolean isAlive = true;

    //тут создаем картинки дино
    public MainCharacter() {
        normalRun = new Animation(200);
        normalRun.addFrame(Resourse.getResourceImage("src/main/resources/main-character1.png"));
        normalRun.addFrame(Resourse.getResourceImage("src/main/resources/main-character2.png"));
        downRunAnim = new Animation(200);
        downRunAnim.addFrame(Resourse.getResourceImage("src/main/resources/main-character5.png"));
        downRunAnim.addFrame(Resourse.getResourceImage("src/main/resources/main-character6.png"));
        rect = new Rectangle();
    }

    public void update() {
        normalRun.update(); //код бега
        // это код линии для прыжков
        if (y >= GROUNDY - normalRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUNDY - normalRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
        rect.x = (int) x;
        rect.y = (int) y;
        rect.width = normalRun.getFrame().getWidth();
        rect.height = normalRun.getFrame().getHeight();
    }

    public Rectangle getBound() {
        return rect;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);//цвет квадрата
        //g.drawRect((int) x, (int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());
        g.drawImage(normalRun.getFrame(), (int) x, (int) y, null);
    }


    //прыжки
    public  void jump() {
        speedY = -4;
        y += speedY;
        GameScreen.jumpSound.play();
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean getAlive() {
        return isAlive;
    }
}
