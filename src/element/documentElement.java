package element;
import java.util.Date;

public class documentElement extends htmlElement {
    private String src;
    private String thumbnail;
    private StringBuilder content = new StringBuilder();
    private int width = 200, height = 160;

    public documentElement(String src, String description, String author, String name, String location, Date lastmodified, long size) {
        super(description, author, name, location, lastmodified, size);
        this.src = src;
        generateThumbNail();
        generateTag();
    }


    private void generateThumbNail() {
        thumbnail thumb = new thumbnail();
        String docType = "";
        for (int i = 0; i < src.length(); i++)
            if (src.charAt(i) == '.') {
                docType = src.substring(i + 1);
                break;
            }

        if (thumb.getDocumentThumbs().containsKey(docType))
            thumbnail = thumb.getDocumentThumbs().get(docType);
        else
            thumbnail = thumb.getDocumentThumbs().get("doc");
    }


    private void generateTag() {
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
