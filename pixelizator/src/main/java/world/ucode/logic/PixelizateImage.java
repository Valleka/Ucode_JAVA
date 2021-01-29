package world.ucode.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PixelizateImage {
    public BufferedImage image;
    public InputStream toPixel(InputStream in, int size) throws IOException {
        image = ImageIO.read(in);
        int h = image.getHeight();
        int w = image.getWidth();
        BufferedImage imgRes = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < w; i += size) {
            for (int j = 0; j < h; j += size) {
                int pixel = makePicture(image, i, j, size);
                for (int dw = i; (dw < i + size) && (dw < imgRes.getWidth()); dw++) {
                    for (int dh = j; (dh < j + size) && (dh < imgRes.getHeight()); dh++) {
                        imgRes.setRGB(dw, dh, pixel);
                    }
                }
            }
        }
        return  toStream(imgRes);
    }

    private InputStream toStream(BufferedImage imgRes) throws  IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(imgRes, "jpeg", stream);
        return new ByteArrayInputStream(stream.toByteArray());
    }

    private int makePicture(BufferedImage image, int i, int j, int sizeOfPixel) {
        sizeOfPixel = ++sizeOfPixel / 2;
        int wCenter = i + sizeOfPixel < image.getWidth() ? i + sizeOfPixel : i;
        int hCenter = j + sizeOfPixel < image.getHeight() ? j + sizeOfPixel : j;
        return image.getRGB(hCenter, wCenter);
    }
}
