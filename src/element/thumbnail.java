package element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class thumbnail
{
    private String src;

    /**
     * generates image thumbnail using rescaling method provided by bufferedImage
     * it doesn't regenerate a thumbnail if it already exists
     * @param src is the path of the original image
     * @param type is the type of thumbnail
     * @param x is the width of the thumbnail in dot pixels
     * @param y is the height of the thumbnail in dot pixels
     * */
    void generateImageThumb(int x, int y, String src, String type) throws IOException
    {
        this.src = src;
        createDirectory();

        //check if thumbnail already exists
        if (!new File("thumbs/" + src).exists())
        {
            BufferedImage img = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            img.createGraphics().drawImage(ImageIO.read(new File(src)).getScaledInstance(x, y, Image.SCALE_DEFAULT), 0, 0, null);
            ImageIO.write(img, type, new File("thumbs/" + src));
        }
    }

    public String getSrc()
    {
        return "thumbs/" + src;
    }

    /**
     * Checks if directory exists; if it doesn't then it creates one
     * */
    private void createDirectory()
    {
        String string = src;
        int pos = 0;
        for (int i = string.length() - 1; i >= 0; i--)
            if (src.charAt(i) == '/')
            {
                pos = i;
                break;
            }

        string = string.substring(0, pos);

        File file = new File("thumbs/" + string);
        if (!file.isDirectory())
            file.mkdirs();
    }
}
