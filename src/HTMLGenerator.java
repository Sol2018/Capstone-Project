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

        StringBuilder images = new StringBuilder();

        for (File file : metaDataFiles) {
            xmlReader = new XMLReader(file);

            if (xmlReader.getRoot().getTagName().compareTo("image") == 0) {
                //TODO load image
                images.append(HTMLTags.openDiv("", "\"item\""));
                images.append(HTMLTags.openA("\"_blank\"", "", "\"" + xmlReader.getValue("src") + "\""));
                images.append(HTMLTags.img(xmlReader.getValue("src")));
                images.append(HTMLTags.openDiv("", "\"desc\"")).append(xmlReader.getValue("description")).append(HTMLTags.closeDiv());
                images.append(HTMLTags.closeA());
                images.append(HTMLTags.closeDiv());

            } else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0) {
                //TODO load a list of images
                //current directory
                File Objectfile = new File(xmlReader.getValue("src"));

                //search for all xml files
                File[] files = Objectfile.listFiles();

                assert files != null;
                for (File file1 : files) {
                    //TODO load image
                    if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0) {
                        images.append(HTMLTags.openDiv("", "\"item\""));
                        images.append(HTMLTags.openA("\"_blank\"", "", "\"" + file1.getPath() + "\""));
                        images.append(HTMLTags.img(file1.getPath()));
                        images.append(HTMLTags.openDiv("", "\"desc\"")).append(xmlReader.getValue("description")).append(HTMLTags.closeDiv());
                        images.append(HTMLTags.closeA());
                        images.append(HTMLTags.closeDiv());
                    }
                }

            }
        }

        //generate the articles html
        writeHTML("articles", images.toString());

        //generate the projects html
        writeHTML("projects", images.toString());

        //generate the gallery html
        writeHTML("gallery", images.toString());

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
    private static void writeHTMLtoFile(String text, String name) {
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


    private static void writeHTML(String page, String data) {
        String content =
                HTMLTags.openHTML("en") + HTMLTags.commonHead() +
                HTMLTags.openBody("\"getItems()\"", "\"container-fluid jumbotron\"") +
                HTMLTags.comment("Navigation Bar") +
                HTMLTags.openDiv("", "\"nav col-md-12\"") +
                        HTMLTags.openA("", "", "\"#\"") + "Home" + HTMLTags.closeA();

        switch (page) {
            case "projects":
                content += HTMLTags.openA("", "", "gallery.html") + "Pictures" + HTMLTags.closeA() +
                        HTMLTags.openA("", "", "articles.html") + "Documents" + HTMLTags.closeA() +
                        HTMLTags.openA("", "active", "\"#\"") + "projects" + HTMLTags.closeA();
                break;
            case "articles":
                content += HTMLTags.openA("", "", "gallery.html") + "Pictures" + HTMLTags.closeA() +
                        HTMLTags.openA("", "active", "\"#\"") + "Documents" + HTMLTags.closeA() +
                        HTMLTags.openA("", "", "projects.html") + "projects" + HTMLTags.closeA();
                break;
            case "gallery":
                content += HTMLTags.openA("", "active", "\"#\"") + "Pictures" + HTMLTags.closeA() +
                        HTMLTags.openA("", "", "articles.html") + "Documents" + HTMLTags.closeA() +
                        HTMLTags.openA("", "", "projects.html") + "projects" + HTMLTags.closeA();
                break;
        }

        content +=
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
                        HTMLTags.h("Web-based Digital Object Showcase: " + page, 3) +
                HTMLTags.closeDiv() +
                HTMLTags.breakRule() +
                HTMLTags.openDiv("", "\"row grid-container\"") +
                HTMLTags.comment("Category section") +
                HTMLTags.openDiv("", "\"category col-md-2\"") +
                HTMLTags.openDiv("", "") +
                HTMLTags.h("Categories:", 5) +
                        HTMLTags.openDiv("", "");

        switch (page) {
            case "projects":
                content +=
                        HTMLTags.openA("", "", "\"gallery.html\"") + "Pictures" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "\"active\"", "\"projects.html\"") + "Documents" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "", "\"#\"") + "Projects" + HTMLTags.closeA();
                break;
            case "articles":
                content +=
                        HTMLTags.openA("", "", "\"gallery.html\"") + "Pictures" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "", "\"#\"") + "Documents" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "", "projects.html") + "Projects" + HTMLTags.closeA();
                break;
            case "gallery":
                content +=
                        HTMLTags.openA("", "active", "\"#\"") + "Pictures" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "", "articles.html") + "Documents" + HTMLTags.closeA() +
                                HTMLTags.closeDiv() +
                                HTMLTags.openDiv("", "") +
                                HTMLTags.openA("", "", "projects.html") + "Projects" + HTMLTags.closeA();
                break;
        }
        content +=
                HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +
                HTMLTags.comment("item Section") +
                HTMLTags.openDiv("", "\"gallery col-md-10\"") +
                        //TODO data
                        data +
                HTMLTags.closeDiv() +
                HTMLTags.closeDiv() +
                HTMLTags.closeBody() +
                HTMLTags.closeHTML();
        writeHTMLtoFile(content, page + ".html");
    }

}
