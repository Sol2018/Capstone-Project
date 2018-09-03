package element;
import java.util.Date;

/**
 * This class is responsible for the specialization of a generic html element
 * */
public class documentElement extends htmlElement
{
    private String src;
    private String thumbnail;
    private StringBuilder content = new StringBuilder();
    private static final int width = 200, height = 160;

    /**
     * Constructor initializes super class and generates thumbnail for this element
     * */
    public documentElement(String src, String description, String author, String name, String location, Date lastmodified, long size)
    {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateThumbNail();
        generateTag();
    }


    /**
     * generates thumbnail for the document element
     * @implNote checks the extension of the file and maps it to an existing thumbnail
     * */
    private void generateThumbNail()
    {
        thumbnail thumb = new thumbnail();
        String docType = "";
        for (int i = 0; i < src.length(); i++)
            if (src.charAt(i) == '.')
            {
                docType = src.substring(i + 1);
                break;
            }

        thumbnail = thumb.generateDocThumb(docType);
    }


    /**
     * implements document html tag
     * */
    private void generateTag()
    {
        content.append("<div class=\"item\"><a target=\"_blank\" href=\"");
        content.append(src); //target image
        content.append("\">");
        content.append("<");
        content.append("img width=");
        content.append(width);
        content.append(" height=");
        content.append(height);
        content.append(" ");
        content.append(" src=\"");
        content.append(thumbnail);    //thumbnail
        content.append("\"> ");
        content.append("</a>");

        super.setContent(content.toString());
    }
}
