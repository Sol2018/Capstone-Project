import java.util.ArrayList;

class HTMLGenerator
{
    public static void main(String[] args)
    {
      ContentGenerator contentGenerator = new ContentGenerator(args[0]);
      contentGenerator.generateImageContent();
      contentGenerator.generateDocumentContent();
      contentGenerator.generateVideoContent();
      contentGenerator.generateAudioContent();
      String images = contentGenerator.getImages();
      String docs = contentGenerator.getDocuments();
      String vids = contentGenerator.getVideos();
      String audio = contentGenerator.getAudio();
      Template template = new Template("Template.html");
      ArrayList<String> coverA = template.setUpPageTemplate("images");
      ArrayList<String> coverB = template.setUpPageTemplate("videos");
      ArrayList<String> coverC = template.setUpPageTemplate("audio");
      ArrayList<String> coverD = template.setUpPageTemplate("documents");

      contentGenerator.writeHTMLtoFile(coverA.get(0)+images+coverA.get(1),"images.html");
      contentGenerator.writeHTMLtoFile(coverB.get(0)+vids+coverB.get(1),"videos.html");
      contentGenerator.writeHTMLtoFile(coverC.get(0)+audio+coverC.get(1),"audio.html");
      contentGenerator.writeHTMLtoFile(coverD.get(0)+docs+coverD.get(1),"documents.html");
    }
}
