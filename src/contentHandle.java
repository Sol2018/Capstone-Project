import element.*;
import readers.XMLReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * class is responsible for creating generic html that are sent
 * */
class contentHandle
{
    private ArrayList<File> metaDataFiles = new ArrayList<>(0);
    private ArrayList<htmlElement> elements;

    contentHandle(ArrayList<File> metaDataFiles)
    {
        this.metaDataFiles = metaDataFiles;
    }

    /**
     * Read xml files for content and add content elements to the elements list
     * @param type is the identifier of a single object xml
     */
    void generateContent(String type)
    {
        elements = new ArrayList<>(0);
        ArrayList<Thread> threads = new ArrayList<>(0);

        for (File file : metaDataFiles)
        {
            XMLReader xmlReader = new XMLReader(file);

            if (xmlReader.getRoot().getTagName().compareTo(type) == 0) {
                Thread thread = new Thread(() -> addNewElement(xmlReader, xmlReader.getValue("src"), new File(xmlReader.getValue("src")), type));
                thread.start();
                threads.add(thread);
            }


            else if (xmlReader.getRoot().getTagName().compareTo(type + "Lib") == 0)
            {
                //load all files in directory
                File[] files = new File(xmlReader.getValue("src")).listFiles();
                assert files != null;
                for (File file1 : files)
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0) {
                        Thread thread = new Thread(() -> addNewElement(xmlReader, file1.getPath(), file1, type));
                        thread.start();
                        threads.add(thread);
                    }
            }
        }

        for (Thread t : threads)
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }


    /**
     * [refactoring], this helps handle the addition of different elements
     * */
    private synchronized void addNewElement(XMLReader xmlReader, String src, File file, String type)
    {
        switch (type)
        {
            case "image":
                elements.add(new imageElement(src, xmlReader.getValue("description"),
                        xmlReader.getValue("author"), file.getName(), xmlReader.getValue("location"),
                        new Date(file.lastModified()), file.length()));
                break;

            case "video":
                elements.add(new videoElement(src, xmlReader.getValue("description"),
                        xmlReader.getValue("author"), file.getName(), xmlReader.getValue("location"),
                        new Date(file.lastModified()), file.length()));
                break;

            case "audio":
                elements.add(new audioElement(src, xmlReader.getValue("description"),
                        xmlReader.getValue("author"), file.getName(), xmlReader.getValue("location"),
                        new Date(file.lastModified()), file.length()));
                break;

            case "document":
                elements.add(new documentElement(src, xmlReader.getValue("description"),
                        xmlReader.getValue("author"), file.getName(), xmlReader.getValue("location"),
                        new Date(file.lastModified()), file.length()));
                break;
        }

    }


    ArrayList<htmlElement> getElements() {
        return elements;
    }
}
