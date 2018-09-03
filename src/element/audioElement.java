package element;

import java.util.Date;

public class audioElement extends htmlElement
{
    private String src;
    private StringBuilder content = new StringBuilder();

    public audioElement(String src, String description, String author, String name, String location, Date lastmodified, long size) {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateTag();
    }

    private void generateTag() {
        content.append("<div class=\"item\">");
        content.append("<audio  controls>\n");
        content.append(" <source src=\"");
        content.append(src);
        content.append("\">\n");
        content.append("Your browser does not support the video tag.\n");
        content.append("</audio>");

        super.setContent(content.toString());
    }
}
