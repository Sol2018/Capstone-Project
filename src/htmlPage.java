import element.imageElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class htmlPage
{
    private final ArrayList<String> templatePage;
    private StringBuilder imageContent = new StringBuilder();
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);

    /**
     */
    htmlPage(ArrayList<String> templatePage, ArrayList<File> metaDataFiles)
    {
        this.metaDataFiles = metaDataFiles;
        this.templatePage = templatePage;
    }


    /**
     * Read image content from xml files and write it to String Builder
     */
    void generateImageContent()
    {
        for (File file : metaDataFiles)
        {
            XMLreader xmlReader = new XMLreader(file);

            if (xmlReader.getRoot().getTagName().compareTo("image") == 0)
            {
                imageElement image = new imageElement(xmlReader.getValue("src"), xmlReader.getValue("description"));
                imageContent.append(image.getImages());

            } else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0)
            {
                //TODO load a list of images
                //load all files in directory
                File[] files = new File(xmlReader.getValue("src")).listFiles();

                assert files != null;
                for (File file1 : files)
                {
                    //TODO load image
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
                    {
                        imageElement image = new imageElement(file1.getPath(), xmlReader.getValue("description"));
                        imageContent.append(image.getImages());
                    }
                }
            }
        }
        writeHTMLtoFile(templatePage.get(0)+imageContent+templatePage.get(1),"images.html");
    }





    /**
     * Writes text to a new html file
     * @param name is the name of the html file
     * @param text is the content of the file
     */
    public void writeHTMLtoFile(String text, String name)
    {
        BufferedWriter output = null;
        try {
            File file = new File(name);
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
