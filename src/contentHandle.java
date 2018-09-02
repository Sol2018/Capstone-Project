import element.htmlElement;
import element.imageElement;

import java.io.File;
import java.util.ArrayList;

public class contentHandle {
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);
    private ArrayList<htmlElement> elements;

    contentHandle(ArrayList<File> metaDataFiles) {
        this.metaDataFiles = metaDataFiles;
    }

    /**
     * Read xml files for images and add image elements to the elements list
     */
    void generateImageContent() {
        elements = new ArrayList<>(0);

        for (File file : metaDataFiles) {
            XMLReader xmlReader = new XMLReader(file);

            if (xmlReader.getRoot().getTagName().compareTo("image") == 0) {
                elements.add(new imageElement(xmlReader.getValue("src"), xmlReader.getValue("description")));

            } else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0) {
                //TODO load a list of images
                //load all files in directory
                File[] files = new File(xmlReader.getValue("src")).listFiles();

                assert files != null;
                for (File file1 : files) {
                    //TODO load image
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0) {
                        elements.add(new imageElement(file1.getPath(), xmlReader.getValue("description")));
                    }
                }
            }
        }
    }

    public ArrayList<htmlElement> getElements() {
        return elements;
    }
}