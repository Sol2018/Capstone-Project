package element;

import java.io.IOException;
import java.util.Date;

/**
 * returns an html image element
 * */
public class imageElement extends htmlElement
{
    private String src;
    private String thumbnail;
    private StringBuilder content = new StringBuilder();

    public imageElement(String src, String description, String author, String name, String location, Date lastmodified, double size)
    {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateThumbNail();
        generateTag();
    }

    private void generateThumbNail()
    {
        thumbnail thumb = new thumbnail();
        try {
            thumb.generateImageThumb(300, 200, src, "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        thumbnail = thumb.getSrc();
    }


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

