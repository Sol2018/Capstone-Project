package element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class thumbnail
{
    private String src;     //directory of the thumbnail

    /**
     * maps document type with a thumbnail
     * */
    String generateDocThumb(String docType)
    {
        File file = new File("thumbs/Documents/"+docType+".png");
        if (file.exists())
            return file.getPath();
        return "thumbs/Documents/doc.png";
    }

    /**
     * maps audio type with a thumbnail
     * */
    String generateAudioThumb(String docType)
    {
        File file = new File("thumbs/Audio/"+docType+".png");
        if (file.exists())
            return file.getPath();
        return "thumbs/Audio/audio.png";
    }

    /**
     * generates image thumbnail using rescaling method provided by bufferedImage
     * it doesn't regenerate a thumbnail if it already exists
     * @param x is the width of the thumbnail in dot pixels
     * @param y is the height of the thumbnail in dot pixels
     * @param src is the path of the original image  */
    void generateImageThumb(int x, int y, String src)
    {
        this.src = src;
        createDirectory();

        //check if thumbnail already exists
        if (!new File("thumbs/" + src).exists())
        {
            BufferedImage img = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            try
            {
                Graphics g = img.createGraphics();
                Image image  = ImageIO.read(new File(src));
                if (image!=null)
                    g.drawImage((image).getScaledInstance(x, y, Image.SCALE_DEFAULT), 0, 0, null);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                ImageIO.write(img, "jpg", new File("thumbs/" + src));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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


    public void setSrc(String src)
    {
        this.src = src;
    }

    /**
     * @return returns the directory of the thumbnail
     * */
    public String getSrc()
    {
        return "thumbs/" + src;
    }
}
