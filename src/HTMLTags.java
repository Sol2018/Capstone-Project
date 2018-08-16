//follows MDN web docs
class HTMLTags
{
    /**
     * Main Root
     * */
    static String openHTML(String language)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"" + language + "\">\n\n";
    }

    static String closeHTML()
    {
        return "\n</html>\n";
    }

    static String openBody(String onload, String Class)
    {
        String string = "<body ";

        if (onload.length() > 0)
            string += "onload=" + onload + " ";

        if (Class.length() > 0)
            string += "class=" + Class;
        return string + " >\n";
    }

    static String closeBody()
    {
        return "</body>\n";
    }


    static String comment(String content)
    {
        return "\n<!-- " + content + " -->\n";
    }

    static String openDiv(String id, String Class)
    {
        String string = "<div ";

        if (id.length() > 0)
            string += "id=" + id + " ";

        if (Class.length() > 0)
            string += "class=" + Class;

        return string + " >\n";
    }

    static String closeDiv()
    {
        return "</div>\n";
    }

    static String openA(String target, String Class, String href)
    {
        String string = "<a ";

        if (target.length() > 0)
            string += "target=" + target + " ";

        if (Class.length() > 0)
            string += "class=" + Class;

        if (href.length() > 0)
            string += "href=" + href;

        return string + " >\n";
    }

    static String closeA()
    {
        return "</a>\n";
    }

    static String horizontalRule()
    {
        return "\n<hr>\n";
    }


    static String span(String s) {
        return "<span>" + s + "</span>\n";
    }

    static String input(String type, String placeholder) {
        String string = "<input ";

        if (type.length() > 0)
            string += "type=" + type;

        if (placeholder.length() > 0)
            string += "placeholder=" + placeholder;

        return string + ">\n";
    }

    static String button(String content) {
        return "<button>" + content + "</button>\n";
    }

    static String h(String content, int level) {
        return "<h" + level + ">" + content + "</h" + level + ">\n";
    }


    static String breakRule() {
        return "<br>\n";
    }


    static String img(String s) {
        return "<img src=" + s + ">\n";
    }


    /**
     * This head tag is consistent across current html pages -hence it is hardcoded
     */
    static String commonHead() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\n" +
                "        crossorigin=\"anonymous\">\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "    <title>WEBDOS | Capstone Project</title>\n" +
                "</head>\n\n";
    }

    static String openUl()
    {
        return "<ul>\n";
    }

    static String closeUl()
    {
        return "</ul>\n";
    }

    static String openLi() {
        return "<li>\n";
    }

    static String closeLi() {
        return "</li>\n";
    }

    static String Strong(String content)
    {
        return "<strong>"+content+"</strong>\n";
    }
}
