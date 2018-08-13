import java.io.File;
import java.util.ArrayList;

class HTMLGenerator
{

    public static void main(String[] args)
    {
        System.out.println("Root directory entered by the user: "+args[0]);

        //Searching for all xml files
        findXMLs(args[0]);
        XMLReader xmlReader = new XMLReader(metaDataFiles.get(0));
        System.out.println(xmlReader.getRoot().getTagName());
    }

    private static ArrayList<File> metaDataFiles = new ArrayList<>(0);

    /**
     * Recursively finds all XML files in the provided directory and adds them to the metaDataFiles ArrayList
     * @param arg is the current directory
     * */
    private static void findXMLs(String arg)
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

}