import element.htmlElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class htmlPage
{
    private ArrayList<String> templatePage;
    private ArrayList<htmlElement> elements;


    /**
     */
    htmlPage(ArrayList<String> templatePage, ArrayList<htmlElement> elements)
    {
        this.templatePage = templatePage;
        this.elements = elements;
        process();

        String s = templatePage.get(0);
        for (htmlElement e : elements)
            s += "\n" + e.toString();
        s += templatePage.get(1);
        writeHTMLtoFile(s, "images.html");
    }

    /**
     * does some activities
     * */
    private void process() {
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
