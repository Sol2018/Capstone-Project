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
        XMLReader xmlReader = new XMLReader(metaDataFiles.get(0));
        System.out.println(xmlReader.getRoot().getTagName());

        Test();
    }

    /*
    * Method tests if html page can be really generated
    * */
    private static void Test() {
        System.out.println("Creating Page with Audio");

        String text;
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("AUDIO test"));

        text += HTMLTags.body(HTMLTags.nav("", "menu",
                //body content

                //heading
                HTMLTags.sectionHeader("", "", 1, "SAMPLE PAGE SHOWING AUDIO") +

                        //unordered list
                        HTMLTags.ul("", "",

                                //list item 1
                                HTMLTags.li("", "", "", HTMLTags.a("", "", "", "home.html", "", "", "", "", "HOMEPAGE")) +
                                        //list item 2
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "image.html", "", "", "", "", "IMAGE")) +
                                        //list item 3
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "video.html", "", "", "", "", "VIDEO"))
                        ) +

                        HTMLTags.audio("t-rex-roar", "", "", "\"controls\"", "", "", "", "\'auto\'", "\"TestDATA/audio/04. Binaural Test.mp3\"",
                                "Your browser does not support the <code>audio</code> element.")
                )
        );


        text += HTMLTags.closeHTML();


        BufferedWriter output = null;
        try {
            File file = new File("audio.html");
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

        /**
         * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
         * */
        System.out.println("Creating Page with Image");
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("Image test"));

        text += HTMLTags.body(HTMLTags.nav("", "menu",
                //body content

                //heading
                HTMLTags.sectionHeader("", "", 1, "SAMPLE PAGE SHOWING IMAGE") +

                        //unordered list
                        HTMLTags.ul("", "",

                                //list item 1
                                HTMLTags.li("", "", "", HTMLTags.a("", "", "", "home.html", "", "", "", "", "HOMEPAGE")) +
                                        //list item 2
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "audio.html", "", "", "", "", "AUDIO")) +
                                        //list item 3
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "video.html", "", "", "", "", "VIDEO"))
                        ) +

                        HTMLTags.img("", "", "", "", "", "356", "", "", "\"TestDATA/photos/people/group.jpg\"", "500", "", "")
                )
        );


        text += HTMLTags.closeHTML();


        output = null;
        try {
            File file = new File("image.html");
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


        System.out.println("Creating Page with Video");
        /**
         * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
         * */
        System.out.println("Creating Page with Image");
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("Image test"));

        text += HTMLTags.body(HTMLTags.nav("", "menu",
                //body content

                //heading
                HTMLTags.sectionHeader("", "", 1, "SAMPLE PAGE SHOWING VIDEO") +

                        //unordered list
                        HTMLTags.ul("", "",

                                //list item 1
                                HTMLTags.li("", "", "", HTMLTags.a("", "", "", "home.html", "", "", "", "", "HOMEPAGE")) +
                                        //list item 2
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "audio.html", "", "", "", "", "AUDIO")) +
                                        //list item 3
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "image.html", "", "", "", "", "IMAGE"))
                        ) +

                        HTMLTags.video("", "", "true", "controls", "", "", "", "muted", "autoplay", "", "https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4", "650", "https://upload.wikimedia.org/wikipedia/commons/e/e8/Elephants_Dream_s5_both.jpg", "", "Sorry, your browser doesn't support embedded videos.")
                )
        );


        text += HTMLTags.closeHTML();


        output = null;
        try {
            File file = new File("video.html");
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


        System.out.println("Linking Everything...");
        /**
         * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
         * */
        text = HTMLTags.openHTML();

        text += HTMLTags.head(HTMLTags.meta() + HTMLTags.Pagetitle("Home test"));

        text += HTMLTags.body(HTMLTags.nav("", "menu",
                //body content

                //heading
                HTMLTags.sectionHeader("", "", 1, "CAPSTONE PROTOTYPE IN PROGRESS") +

                        //unordered list
                        HTMLTags.ul("", "",

                                //list item 1
                                HTMLTags.li("", "", "", HTMLTags.a("", "", "", "video.html", "", "", "", "", "VIDEO")) +
                                        //list item 2
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "audio.html", "", "", "", "", "AUDIO")) +
                                        //list item 3
                                        HTMLTags.li("", "", "", HTMLTags.a("", "", "", "image.html", "", "", "", "", "IMAGE"))
                        ) +

                        HTMLTags.main("", "", HTMLTags.p("", "", "Auto generator in progress"))
                )
        );


        text += HTMLTags.closeHTML();


        output = null;
        try {
            File file = new File("home.html");
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
        System.out.print("Page address: " + (char) 27 + "[31m");
        System.out.println("home.html");

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
