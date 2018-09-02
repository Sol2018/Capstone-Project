package element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class thumbnail {
    private String src;


    void generateImageThumb(int x, int y, String src, String type) throws IOException {
        this.src = src;
        createDirectory();
        BufferedImage img = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(new File(src)).getScaledInstance(x, y, Image.SCALE_DEFAULT), 0, 0, null);
        ImageIO.write(img, type, new File("thumbs/" + src));
    }

    public String getSrc() {
        return "thumbs/" + src;
    }

    private void createDirectory() {
        String string = src;
        int pos = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (src.charAt(i) == '/') {
                pos = i;
                break;
            }
        }
        string = string.substring(0, pos);

        File file = new File("thumbs/" + string);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }
}
