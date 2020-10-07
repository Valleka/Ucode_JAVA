package world.ucode.objectgame;

import world.ucode.GameScreen;
import world.ucode.util.Resourse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static world.ucode.GameScreen.GROUNDY;

public class Land {

    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;
    private Random random;


    public Land(GameScreen game) {
        //конструктор
        random = new Random();
        imageLand1 = Resourse.getResourceImage("src/main/resources/land1.png");
        imageLand2 = Resourse.getResourceImage("src/main/resources/land2.png");
        imageLand3 = Resourse.getResourceImage("src/main/resources/land3.png");
        listImage = new ArrayList<ImageLand>();

        //движение земли относительно дино
        int numberOfLandTitle = 600 / imageLand1.getWidth() + 2;
        for (int i = 0; i < numberOfLandTitle; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i * imageLand1.getWidth());
            imageLand.image = getImageLand(); //рандомно выводит картинки с землей
            listImage.add(imageLand);
        }
    }

    public void update() {
        for (ImageLand imageLand : listImage) {
            imageLand.posX -= 2;
        }
        ImageLand firstElement = listImage.get(0);
        if (firstElement.posX + imageLand1.getWidth() < 0) {
            firstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }

    public void draw(Graphics g) {
        for (ImageLand imageLand : listImage) {
            //позиция дино по вертикали
            g.drawImage(imageLand.image, imageLand.posX, (int) GROUNDY - 20, null);
        }

    }

    private BufferedImage getImageLand() {
        //рандомно ставим разные картинки с землей
        int i = random.nextInt(10);
        switch (i) {
            case 0: return imageLand1;
            case 1: return imageLand3;
            default: return imageLand2;
        }
    }

    private class ImageLand {
        int posX;
        BufferedImage image;
    }
}
