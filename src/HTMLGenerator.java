import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class HTMLGenerator
{

    /**
     * This head tag is consistent across current html pages -hence it is hardcoded
     */
    private static final String head = "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\n" +
            "        crossorigin=\"anonymous\">\n" +
            "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
            "    <title>WEBDOS | Capstone Project</title>\n" +
            "</head>\n\n";

    public static void main(String[] args) {
        System.out.println("Root directory entered by the user: "+args[0]);

        //Searching for all xml files
        findXMLs(args[0]);

        XMLReader xmlReader;

        String images = "<ol>\n\t";

        /*for (File file : metaDataFiles) {
            xmlReader = new XMLReader(file);

            if (xmlReader.getRoot().getTagName().compareTo("image") == 0) {
                //TODO load image
                images += HTMLTags.li("", "", "" + xmlReader.getValue("name"),
                        "" + HTMLTags.img("", "", "", "", "", ""
                                        + xmlReader.getValue("height"), "", "", "" + xmlReader.getValue("src"),
                                "" + xmlReader.getValue("width"), "", "" + xmlReader.getValue("alt")));
                images += "\n";

            } else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0) {
                //TODO load a list of images
                //current directory
                File Objectfile = new File(xmlReader.getValue("src"));

                //search for all xml files
                File[] files = Objectfile.listFiles();

                for (File file1 : files) {
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0) {
                        images += HTMLTags.li("", "", "" + file1.getName(),
                                "" + HTMLTags.img("", "", "", "", "", "", "", "", "" + file1.getPath(), "", "", "" + file1.getName()));
                        images += "\n";
                    }
                }

            }
        }

        images += "\n</ol>\n";*/

        //generate the articles html
        Articles();

    }

    private static ArrayList<File> metaDataFiles = new ArrayList<>(0);

    /**
     * Recursively finds all XML files in the provided directory and adds them to the metaDataFiles ArrayList
     * @param arg is the current directory
     * */
    private static void findXMLs(String arg) {
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
     * Writes text to a new html file
     *
     * @param name is the name of the html file
     * @param text is the content of the file
     */
    private static void writeHTML(String text, String name) {
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

    /**
     * Writing the arcles html
     */
    private static void Articles() {
        String content = HTMLTags.openHTML("en");

        content += head +

                HTMLTags.openBody("\"getItems()\"", "\"container-fluid jumbotron\"") +

                HTMLTags.comment("Navigation Bar") +

                HTMLTags.openDiv("", "\"nav col-md-12\"") +
                HTMLTags.openA("", "", "\"#\"") + "Home" + HTMLTags.closeA() +
                HTMLTags.openA("", "", "gallery.html") + "Pictures" + HTMLTags.closeA() +
                HTMLTags.openA("", "active", "\"#\"") + "Documents" + HTMLTags.closeA() +
                HTMLTags.openA("", "", "projects.html") + "projects.html" + HTMLTags.closeA() +
                HTMLTags.closeDiv() +

                HTMLTags.horizontalRule() +

                HTMLTags.comment("Search Bar") +

                HTMLTags.openDiv("", "\"col-md-12 search\"") +
                HTMLTags.span("Search the Titles and Keywords :") +
                HTMLTags.input("\"text\"", "\"Search..\"") +
                HTMLTags.button("Go") +
                HTMLTags.closeDiv() +

                HTMLTags.horizontalRule() +

                HTMLTags.comment("Title") +

                HTMLTags.openDiv("\"title\"", "\"col-md-12\"") +
                HTMLTags.h("Web-based Digital Object Showcase: Documents", 3) +
                HTMLTags.closeDiv() +

                HTMLTags.breakRule() +

                HTMLTags.openDiv("", "\"row grid-container\"") +

                HTMLTags.comment("Category section") +

                HTMLTags.openDiv("", "\"category col-md-2\"") +
                HTMLTags.openDiv("", "") +
                HTMLTags.h("Categories:", 5) +
                HTMLTags.openDiv("", "") +
                HTMLTags.openA("", "", "\"gallery.html\"") + "Pictures" + HTMLTags.closeA() +
                HTMLTags.closeDiv() +
                HTMLTags.openDiv("", "") +
                HTMLTags.openA("", "\"active\"", "\"#\"") + "Documents" + HTMLTags.closeA() +
                HTMLTags.closeDiv() +
                HTMLTags.openDiv("", "") +
                HTMLTags.openA("", "", "\"projects.html\"") + "Projects" + HTMLTags.closeA() +
                HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +

                HTMLTags.openDiv("", "\"gallery col-md-10\"") + HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +
                HTMLTags.closeBody() +
                HTMLTags.closeHTML();

        writeHTML(content, "articles.html");

    }

}
