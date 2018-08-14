import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class HTMLGenerator
{

    public static void main(String[] args) {
        System.out.println("Root directory entered by the user: "+args[0]);

        //Searching for all xml files
        findXMLs(args[0]);

        XMLReader xmlReader;

        String images = "<ol>\n\t";

        for (File file : metaDataFiles) {
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

        images += "\n</ol>\n";
        HomePage();

        Images(images);

    }

    private static void Images(String images) {
        System.out.println("Creating Images index");

        String text;
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("CAPSTONE PROJECT"));

        text += HTMLTags.body
                (
                        //body content
                        // TODO scripts go in here


                        "" + getHeader() +

                                HTMLTags.main("", "", "" + HTMLTags.sectionHeader("", "", 1,
                                        "This page needs some serious styling")
                                ) +
                                HTMLTags.section("", "",
                                        "" + HTMLTags.a("", "", "", "videos.html", "", "", "", "", "go to videos"))
                                +
                                HTMLTags.section("", "",
                                        "" + HTMLTags.a("", "", "", "documents.html", "", "", "", "", "go to documents"))
                                +
                                HTMLTags.sectionHeader("", "", 1, "IMAGES")
                                +
                                images

                );

        text += HTMLTags.closeHTML();

        writeHTML(text, "images.html");
    }

    /**
     * Returns header consistent among different pages
     */
    private static String getHeader() {
        return HTMLTags.header("", "",
                "" + HTMLTags.a("", "", "", "homepage.html", "", "", "", "",
                        "" + HTMLTags.img("", "", "", "", "", "250", "", "", "SiteObjects/logo.png", "400", "",
                                "")
                ) + HTMLTags.input("", "", "placeholder=Search", "") +
                        HTMLTags.details("", "", "",
                                "" + HTMLTags.summary("", "", "Filters") +
                                        HTMLTags.a("", "", "", "#", "", "", "", "", "Filter1") +
                                        HTMLTags.a("", "", "", "#", "", "", "", "", "Filter2") +
                                        HTMLTags.a("", "", "", "#", "", "", "", "", "Filter3") +
                                        HTMLTags.a("", "", "", "#", "", "", "", "", "Filter4")
                        )

        );
    }

    /**
     * Generates homepage
     */
    private static void HomePage() {
        System.out.println("Creating Homepage");

        String text;
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("CAPSTONE PROJECT"));

        text += HTMLTags.body
                (
                        //body content
                        // TODO scripts go in here


                        "" + getHeader() +

                                HTMLTags.main("", "", "" + HTMLTags.sectionHeader("", "", 1,
                                        "This page needs some serious styling")
                                ) +
                                HTMLTags.section("", "",
                                        "" + HTMLTags.a("", "", "", "images.html", "", "", "", "", "go to images"))
                                +
                                HTMLTags.section("", "",
                                        "" + HTMLTags.a("", "", "", "videos.html", "", "", "", "", "go to videos"))
                                +
                                HTMLTags.section("", "",
                                        "" + HTMLTags.a("", "", "", "documents.html", "", "", "", "", "go to documents"))

                );

        text += HTMLTags.closeHTML();

        writeHTML(text, "homepage.html");
    }


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

}
