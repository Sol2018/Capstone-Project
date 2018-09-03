package element;

import java.util.Date;

public class htmlElement {
    private String description;
    private final String name;
    private final String location;
    private final Date lastmodified;
    private final double size;
    private String author;
    private StringBuilder content = new StringBuilder();
    private String out;

    htmlElement(String description, String author, String name, String location, Date lastmodified, double size) {
        this.description = description;
        this.author = author;
        this.name = name;
        this.location = location;
        this.lastmodified = lastmodified;
        this.size = size;
        describe();
    }

    private void describe() {
        content.append("<div class=\"desc\"  >");
        content.append(description);
        content.append("</div></div>\n");
    }

    String getDescription() {

        return content.toString();
    }

    public String toString() {
        return out;
    }

    public void setContent(String content) {
        out = content + this.content.toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public double getSize() {
        return size;
    }
}
