package element;

public class htmlElement {
    private String description;
    private StringBuilder content = new StringBuilder();
    private String out;

    htmlElement(String description) {
        this.description = description;
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
}
