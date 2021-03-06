package element;
import java.util.Date;

/**
 * This class is responsible for the specialization of a generic html element
 * */
public class videoElement extends htmlElement
{
    private String src;
    private StringBuilder content = new StringBuilder();
private int width = 250;
    private int height = 240;

    /**
     * Constructor initializes super class
     * */
    public videoElement(String src, String description, String author, String name, String location, Date lastmodified, long size)
    {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateTag();
    }

    /**
     * implements video html tag
     * */
    private void generateTag()
    {
        content.append("<div class=\"item\">");
        content.append("<video width=\"");
        content.append(width);
        content.append("\" height=\"");
        content.append(height);
        content.append("\" controls>\n");
        content.append(" <source src=\"../");
        content.append(src);
        content.append("\">\n");
        content.append("Your browser does not support the video tag.\n");
        content.append("</video>");

        super.setContent(content.toString());
    }
}
