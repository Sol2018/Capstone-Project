package element;
import java.util.Date;

/**
 * This class represents a generic html element
 * */
public class htmlElement
{
    private String description;
    private final String name;
    private final String location;
    private final Date lastmodified;
    private final double size;
    private String author;
    private StringBuilder content = new StringBuilder();
    private String out;

    /**
     * constructor initializes attributes common to all elements and describes the element
     * */
    public htmlElement(String description, String author, String name, String location, Date lastmodified, double size)
    {
        this.description = description;
        this.author = author;
        this.name = name;
        this.location = location;
        this.lastmodified = lastmodified;
        this.size = size;
        describe();
    }


    /**
     * implements the description tag of a generic html element
     * */
    private void describe()
    {
        content.append("<div class=\"desc\"  >");
        content.append("<strong> ").append(name).append("</strong>");
        content.append("<small>");
        content.append("<br /><strong> Author: </strong>").append(author);
        content.append("<br /><strong> Location: </strong>").append(location);
        content.append("<br /><strong> Size: </strong>").append(size+" Bytes");
        content.append("<br /><strong> Modification: </strong>").append(""+lastmodified.toString());
        content.append("<br /><strong> Description: </strong>").append(description);
        content.append("</small>");
        content.append("</div></div>\n");
    }

    public String toString()
    {
        return out;
    }

    /**
     * Merges specialized attributes with the generic attributes
     * */
    public void setContent(String content)
    {
        out = content + this.content.toString();
    }

    public String getAuthor()
    {
        return author;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public Date getLastmodified()
    {
        return lastmodified;
    }

    public double getSize()
    {
        return size;
    }
}
