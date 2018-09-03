import java.io.File;
import java.util.ArrayList;

class HTMLGenerator
{
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);

    public static void main(String[] args)
    {
        if (args.length<1)  //ensures if not reading via
            args = new String[]{"TestDATA"};

        HTMLGenerator htmlGenerator = new HTMLGenerator();
        htmlGenerator.findXMLs(args[0]);

        TemplateReader template = new TemplateReader("Template.html");

        //tailoring template to page type
        ArrayList<String> imagesTemplatePage = template.setUpPageTemplate("images");
        //ArrayList<String> videosTemplatePage = template.setUpPageTemplate("videos");
        //ArrayList<String> documentsTemplatePage = template.setUpPageTemplate("documents");
        //ArrayList<String> audioTemplatePage = template.setUpPageTemplate("audio");


        contentHandle contentHandle = new contentHandle(htmlGenerator.getMetaDataFiles());
        contentHandle.generateImageContent();

        //TODO use threads for performance
        new htmlPage(imagesTemplatePage, contentHandle.getElements());
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
        for(File f: files)
        {
            if (f.getName().length()>3)
            {
                if ((f.getName().substring(f.getName().length()-4,f.getName().length())).compareTo(".xml")==0)
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
    private ArrayList<File> getMetaDataFiles() {
        return metaDataFiles;
    }
}
