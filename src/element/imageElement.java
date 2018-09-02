package element;

/**
 * returns an html image element
 * */
public class imageElement extends htmlElement
{
    private String src;
    private String description;
    private StringBuilder content = new StringBuilder();
    public imageElement(String src, String description) {
        super();
        this.src = src;
        this.description = description;
        generateTag();
    }


    private void generateTag()
    {
        content.append("<div class=\"item\"><a target=\"_blank\" href=\"");
        content.append(src);
        content.append("\">");
        content.append("<");
        content.append("img");
        content.append(" ");
        content.append(" src=\"");
        content.append(src);
        content.append("\"> ");
        content.append("</");
        content.append("img");
        content.append(">");
        content.append("</a>");
        content.append("<div class=\"desc\"  >");
        content.append(description);
        content.append("</div></div>\n");
    }


    /**
     * Get image content in string format
     */
    public String getImages()
    {
        return content.toString();
    }
}

