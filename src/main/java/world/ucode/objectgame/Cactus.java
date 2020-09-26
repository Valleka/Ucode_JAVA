package world.ucode.objectgame;

import world.ucode.util.Resourse;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy {

    private BufferedImage image;
    private int posX, posY;
    private Rectangle rect;
    private MainCharacter mainCharacter;
    private boolean isScoreGot = false;

    public Cactus(MainCharacter mainCharacter) {
        //конструктор
        this.mainCharacter = mainCharacter;
        image = Resourse.getResourceImage("src/main/resources/cactus1.png");
        posX = 200;
        posY =65;
        // коллизия
        rect = new Rectangle();
    }

    public void update() {
        posX -= 2;
        rect.x = posX;
        rect.y = posY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }

    @Override
    public Rectangle getBound() {
        return rect;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, posX, posY, null);
    }



    public void setX(int x) {
        posX = x;
    }

    public void setY(int y) {
        posY = y;
    }

    public void setImage(BufferedImage image) {
        this.image = image; //берем параметр image с шапки private BufferedImage image а не из аргумента этой функции
    }

    @Override
    public boolean isOutOfScreen() {
        return (posX + image.getWidth() < 0);
    }

    @Override
    public boolean isOver() {
        return  (mainCharacter.getX() > posX);
    }

    @Override
    public boolean isScoreGot() {
        return isScoreGot;
    }

    @Override
    public void setIsScoreGot(boolean isScoreGot) {
        this.isScoreGot = isScoreGot;
    }
}
