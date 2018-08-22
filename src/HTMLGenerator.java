import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class HTMLGenerator
{
    public static void main(String[] args)
    {
      HTML html = new HTML(args);
      html.generateImageContent();
      String images = html.getImages();
      html.writeHTMLtoFile(images,"test.html");
    }
}
