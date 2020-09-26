package world.ucode.objectgame;

import world.ucode.util.Resourse;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus {

    private BufferedImage image;
    private int posX, posY;
    private Rectangle rect;

    public Cactus() {
        //конструктор
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

    public Rectangle getBound() {
        return rect;
    }

    public void draw(Graphics g) {
        g.drawImage(image, posX, posY, null);
    }
}
