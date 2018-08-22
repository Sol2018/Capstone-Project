import java.lang.reflect.Array;
import java.util.ArrayList;

class HTMLGenerator
{
    public static void main(String[] args)
    {
      ContentGenerator contentGenerator = new ContentGenerator(args);
      contentGenerator.generateImageContent();
      String images = contentGenerator.getImages();
      TemplateReader template = new TemplateReader();
      ArrayList<String> cover = template.generateConcreteHTML("images");

      contentGenerator.writeHTMLtoFile(cover.get(0)+images+cover.get(1),"images.html");
    }
}
