import element.htmlElement;
import element.imageElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

class contentHandle
{
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);
    private ArrayList<htmlElement> elements;

    contentHandle(ArrayList<File> metaDataFiles)
    {
        this.metaDataFiles = metaDataFiles;
    }

    /**
     * Read xml files for images and add image elements to the elements list
     */
    void generateImageContent()
    {
        elements = new ArrayList<>(0);

        for (File file : metaDataFiles)
        {
            XMLReader xmlReader = new XMLReader(file);

            if (xmlReader.getRoot().getTagName().compareTo("image") == 0)
                addNewElement(xmlReader,xmlReader.getValue("src"),new File(xmlReader.getValue("src")));

            else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0)
            {
                //load all files in directory
                File[] files = new File(xmlReader.getValue("src")).listFiles();
                assert files != null;
                for (File file1 : files)
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
                        addNewElement(xmlReader,file1.getPath(),file1);
            }
        }
    }

    /**
     * Using threads to make process fast
     * */
    //[refactoring] adding new image element
    private void addNewElement(XMLReader xmlReader, String src, File file)
    {
        (new Thread(() -> elements.add(new imageElement(src, xmlReader.getValue("description"),
                xmlReader.getValue("author"), file.getName(), xmlReader.getValue("location"),
                new Date(file.lastModified()), file.length())))).start();

    }


    ArrayList<htmlElement> getElements() {
        return elements;
    }
}
