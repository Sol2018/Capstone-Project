package element;

import java.io.IOException;

/**
 * returns an html image element
 * */
public class imageElement extends htmlElement
{
    private String src;
    private String thumbnail;
    private StringBuilder content = new StringBuilder();

    public imageElement(String src, String description) {
        super(description);
        this.src = src;
        generateThumbNail();
        generateTag();
    }

    private void generateThumbNail() {
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


    /**
     * Get image content in string format
     */
    public String getImages()
    {
        return content.toString() + super.getDescription();
    }
}

