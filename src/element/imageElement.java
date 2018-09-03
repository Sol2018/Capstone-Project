package element;
import java.io.IOException;
import java.util.Date;

/**
 * This class is responsible for the specialization of a generic html element
 * */
public class imageElement extends htmlElement
{
    private String src;
    private String thumbnail;
    private StringBuilder content = new StringBuilder();

    /**
     * Constructor initializes super class and generates thumbnail for this element
     * */
    public imageElement(String src, String description, String author, String name, String location, Date lastmodified, double size)
    {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateThumbNail();
        generateTag();
    }

    /**
     * generates thumbnail for the image element
     * */
    private void generateThumbNail()
    {
        thumbnail thumb = new thumbnail();
        try {
            thumb.generateImageThumb(300, 200, src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        thumbnail = thumb.getSrc();
    }


    /**
     * implements image html tag
     * */
    private void generateTag()
    {
        content.append("<div class=\"item\"><a target=\"_blank\" href=\"");
        content.append(src); //target image
        content.append("\">");
        content.append("<");
        content.append("img");
        content.append(" ");
        content.append(" src=\"");
        content.append(thumbnail);    //thumbnail
        content.append("\"> ");
        content.append("</a>");

        super.setContent(content.toString());
    }

}

