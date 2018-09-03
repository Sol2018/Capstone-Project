import readers.TemplateReader;

import java.io.File;
import java.util.ArrayList;

class HTMLGenerator
{
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);

    public static void main(String[] args) {
        if (args.length<1)  //ensures if not reading via
            args = new String[]{"TestDATA"};


        //--------------IMAGES------------------------------
        /*HTMLGenerator htmlImagesGenerator = new HTMLGenerator();
        htmlImagesGenerator.findXMLs(args[0]);
        readers.TemplateReader imagesTemplate = new readers.TemplateReader("Template.html");

        ArrayList<String> imagesTemplatePage = imagesTemplate.setUpPageTemplate("images");

        contentHandle imagesContentHandle = new contentHandle(htmlImagesGenerator.getMetaDataFiles());
        imagesContentHandle.generateContent("images", "gallery");

        new htmlPage(imagesTemplatePage, imagesContentHandle.getElements(), "images");*/

        //--------------VIDEOS-----------------------------------------
        /*HTMLGenerator htmlVideosGenerator = new HTMLGenerator();
        htmlVideosGenerator.findXMLs(args[0]);
        readers.TemplateReader videosTemplate = new readers.TemplateReader("Template.html");

        ArrayList<String> videosTemplatePage = videosTemplate.setUpPageTemplate("videos");

        contentHandle videosHandle = new contentHandle(htmlVideosGenerator.getMetaDataFiles());
        videosHandle.generateContent("vid", "vidLib");

        new htmlPage(videosTemplatePage, videosHandle.getElements(), "videos");*/
        //--------------------------------------------------------------

        //--------------MUSIC-----------------------------------------
        HTMLGenerator htmlAudioGenerator = new HTMLGenerator();
        htmlAudioGenerator.findXMLs(args[0]);
        TemplateReader audioTemplate = new TemplateReader("Template.html");

        ArrayList<String> audioTemplatePage = audioTemplate.setUpPageTemplate("audio");

        contentHandle audioHandle = new contentHandle(htmlAudioGenerator.getMetaDataFiles());
        audioHandle.generateContent("audio", "audioLib");

        new htmlPage(audioTemplatePage, audioHandle.getElements(), "audio");
        //--------------------------------------------------------------

        //--------------DOCUMENTS-----------------------------------------
        /*HTMLGenerator htmlDocGenerator = new HTMLGenerator();
        htmlDocGenerator.findXMLs(args[0]);
        readers.TemplateReader documentTemplate = new readers.TemplateReader("Template.html");

        ArrayList<String> docTemplatePage = documentTemplate.setUpPageTemplate("document");

        contentHandle documentHandle = new contentHandle(htmlDocGenerator.getMetaDataFiles());
        documentHandle.generateContent("document", "docLib");

        new htmlPage(docTemplatePage, documentHandle.getElements(), "document");*/


    }


    /**
     * Recursively finds all XML files in the provided directory and adds them to the metaDataFiles ArrayList
     * @param arg is the current directory
     * */
    private void findXMLs(String arg) {
        //current directory
        File file = new File(arg);

        //search for all xml files
        File[] files = file.listFiles();

        assert files != null;
        for(File f: files) {
            if (f.getName().length()>3) {
                if ((f.getName().substring(f.getName().length()-4,f.getName().length())).compareTo(".xml")==0) {
                    metaDataFiles.add(f);
                }
            }
            if (f.isDirectory()) {
                findXMLs(f.getAbsolutePath());
            }
        }
    }


    /**
     * returns a file arraylist containing all metadata found in the supplied directory
     * */
    private ArrayList<File> getMetaDataFiles() {
        return metaDataFiles;
    }
}
