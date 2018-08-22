import java.lang.reflect.Array;
import java.util.ArrayList;

class HTMLGenerator
{
    public static void main(String[] args)
    {
      ContentGenerator contentGenerator = new ContentGenerator(args);
      contentGenerator.generateImageContent();
      contentGenerator.generateDocumentContent();
      contentGenerator.generateVideoContent();
      contentGenerator.generateAudioContent();
      String images = contentGenerator.getImages();
      String docs = contentGenerator.getDocuments();
      String vids = contentGenerator.getVideos();
      String audio = contentGenerator.getAudio();
      TemplateReader template = new TemplateReader();
      ArrayList<String> coverA = template.generateConcreteHTML("images");
      ArrayList<String> coverB = template.generateConcreteHTML("videos");
      ArrayList<String> coverC = template.generateConcreteHTML("audio");
      ArrayList<String> coverD = template.generateConcreteHTML("documents");

      contentGenerator.writeHTMLtoFile(coverA.get(0)+images+coverA.get(1),"images.html");
      contentGenerator.writeHTMLtoFile(coverB.get(0)+vids+coverB.get(1),"videos.html");
      contentGenerator.writeHTMLtoFile(coverC.get(0)+audio+coverC.get(1),"audio.html");
      contentGenerator.writeHTMLtoFile(coverD.get(0)+docs+coverD.get(1),"documents.html");
    }
}
