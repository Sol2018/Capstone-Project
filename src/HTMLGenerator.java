import readers.TemplateReader;

import java.io.File;
import java.util.ArrayList;

class HTMLGenerator
{
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);

    public static void main(String[] args)
    {
        if (args.length<1)  //ensures if not reading via
            args = new String[]{"TestDATA"};

        String[] pages = new String[]{"audio", "document", "video", "image"};
        for (String name : pages)
        {
            String[] finalArgs = args;
            (new Thread(() -> new HTMLGenerator().generate(finalArgs[0], name))).start();
        }
    }

    /**
     * generate site
     */
    //TODO rename audio -->> html
    private void generate(String args, String type)
    {
        HTMLGenerator htmlAudioGenerator = new HTMLGenerator();
        htmlAudioGenerator.findXMLs(args);
        TemplateReader audioTemplate = new TemplateReader("Template.html");

        ArrayList<String> audioTemplatePage = audioTemplate.setUpPageTemplate(type);

        contentHandle audioHandle = new contentHandle(htmlAudioGenerator.getMetaDataFiles());
        audioHandle.generateContent(type);

        new htmlPage(audioTemplatePage, audioHandle.getElements(), type);
    }


    /**
     * Recursively finds all XML files in the provided directory and adds them to the metaDataFiles ArrayList
     * @param arg is the current directory
     * */
    private void findXMLs(String arg)
    {
        //current directory
        File file = new File(arg);

        //search for all xml files
        File[] files = file.listFiles();

        assert files != null;
        for (File f : files)
        {
            if (f.getName().length() > 3)
            {
                if ((f.getName().substring(f.getName().length() - 4, f.getName().length())).compareTo(".xml") == 0)
                {
                    metaDataFiles.add(f);
                }
            }
            if (f.isDirectory())
            {
                findXMLs(f.getAbsolutePath());
            }
        }
    }


    /**
     * returns a file arraylist containing all metadata found in the supplied directory
     * */
    private ArrayList<File> getMetaDataFiles()
    {
        return metaDataFiles;
    }
}
