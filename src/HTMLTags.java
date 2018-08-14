//follows MDN web docs
public class HTMLTags
{
    /**
     * Main Root
     * */
    static String openHTML()
    {
        return "\n<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
    }

    static String closeHTML()
    {
        return "\n</html>\n";
    }


    /**
     * Document metadata
     * */
    //TODO check if changing the parameters to just String attribute is better than enumerating all
    /*specifies relationship between the current document and an external source*/
    static String link(String as, String crossorigin, String href, String hreflang,
                       String media, String rel, String sizes, String title, String type)
    {
        String string = "\n<link ";

        if(as.length()>0)
            string+= "as= " + as +" ";

        if(crossorigin.length()>0)
            string+= "crossorigin= " + crossorigin +" ";

        if(href.length()>0)
            string+= "href= " + href +" ";

        if(hreflang.length()>0)
            string+= "hreflang= " + hreflang +" ";

        if(media.length()>0)
            string+= "media= " + media +" ";

        if(rel.length()>0)
            string+= "rel= " + rel +" ";

        if(as.length()>0)
            string+= "sizes= " + sizes +" ";

        string += checkTitle(title);

        if(type.length()>0)
            string+= "type= " + type +" ";

        return string + ">\n";
    }

    /*Sets metadata for html*/
    static String meta()
    {
        return "\n<meta charset=\"utf-8\">\n";
    }

    /*contains style information for a document or part of it*/
    static String style(String type, String media, String nonce, String title, String content)
    {
        String string ="\n<style ";

        if(type.length()>0)
            string+= "type= " + type +" ";

        if(media.length()>0)
            string+= "media= " + media +" ";

        if(nonce.length()>0)
            string+= "media= " + nonce +" ";

        string += checkTitle(title);

        string += ">\n"+ content +"\n";


        return string+"</style>\n";
    }

    /*defines the document's title that is shown in a browser's title bar*/
    static String Pagetitle(String title)
    {
        return "\n<title>\n" + title + "\n</title>\n";
    }


    /**
     * Sectioning root
     * */
    static String head(String content)
    {
        return "\n<head>\n" + content + "\n</head>\n";
    }

    static String body(String content)
    {
        return "\n<body>\n" + content + "\n</body>\n";
    }

    //TODO Content sectioning refactoring-if necessary
    /*represents a self-contained composition*/
    static String article(String id, String clasS, String content)
    {
        String string = "<article";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</article>\n";
    }

    /*represents indirectly related content*/
    static String aside(String id, String clasS, String content)
    {
        String string = "<aside";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</aside>\n";
    }

    static String footer(String id, String clasS, String content)
    {
        String string = "<footer";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</footer>\n";
    }

    /*represents introductory content*/
    static String header(String id, String clasS, String content)
    {
        String string = "<header";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</header>\n";
    }

    static String sectionHeader(String id, String clasS, int level,  String content)
    {
        String string = "<h"+level;
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</h"+level+">\n";
    }

    /*represents a multi-level heading for a section of a document*/
    static String hGroup(String id, String clasS, String content)
    {
        String string = "<hGroup";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</hGroup>\n";
    }

    /*represents dominant content*/
    static String main(String id, String clasS, String content) {
        String string = "<main";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</main>\n";
    }

    /*represents a section of a page whose purpose is to provide navigation links*/
    /*represents dominant content*/
    static String nav(String id, String clasS, String content) {
        String string = "<nav";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</nav>\n";
    }


    /*represents a standalone section*/
    static String section(String id, String clasS, String content) {
        String string = "<section";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</section>\n";
    }


    //TODO Text content
    /*Description details*/
    static String dd(String id, String clasS, String content) {
        String string = "<dd";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</dd>\n";
    }

    /*Description list*/
    static String dl(String id, String clasS, String content) {
        String string = "<dl";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</dl>\n";
    }

    /*Description term*/
    static String dt(String id, String clasS, String content) {
        String string = "<dt";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</dt>\n";
    }


    /*figure caption*/
    static String figcaption(String id, String clasS, String content) {
        String string = "<figcaption";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</figcaption>\n";
    }

    /*figure*/
    static String figure(String id, String clasS, String content) {
        String string = "<figure";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</figure>\n";
    }


    /*Horizontal rule*/
    static String hr(String id, String clasS, String content) {
        String string = "<hr";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</hr>\n";
    }


    /*Ordered list*/
    static String ol(String id, String clasS, String reversed, String type, String start, String content) {
        String string = "<ol";
        string += id(id);
        string += clasS(clasS);

        if (reversed.length() > 0)
            string += "reversed= " + reversed + " ";

        if (type.length() > 0)
            string += "type= " + type + " ";

        if (start.length() > 0)
            string += "start= " + start + " ";

        string += ">\n" + content + "\n";
        return string + "\n</ol>\n";
    }


    /*paragraph*/
    static String p(String id, String clasS, String content) {
        String string = "<p";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</p>\n";
    }


    /*unordered list*/
    static String ul(String id, String clasS, String content) {
        String string = "<ul";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</ul>\n";
    }

    //TODO important for ordering lists, suggestion: make an index html that values object according to the ordering
    // criteria and use that for ordering
    /*list item*/
    static String li(String id, String clasS, String value, String content) {
        String string = "<li";
        string += id(id);
        string += clasS(clasS);

        if (value.length() > 0)
            string += "value= " + value + " ";

        string += ">\n" + content + "\n";
        return string + "\n</li>\n";
    }



    //TODO Inline semantics
    /*anchor element*/
    static String a(String id, String clasS, String download, String href, String hreflang, String rel, String target,
                    String type, String content) {
        String string = "<a ";
        string += id(id);
        string += clasS(clasS);

        if (download.length() > 0)
            string += "download= " + download + " ";

        if (href.length() > 0)
            string += "href= " + href + " ";

        if (hreflang.length() > 0)
            string += "hreflang= " + hreflang + " ";

        if (rel.length() > 0)
            string += "rel= " + rel + " ";

        if (target.length() > 0)
            string += "target= " + target + " ";

        if (type.length() > 0)
            string += "type= " + type + " ";

        string += ">\n" + content + "\n";
        return string + "\n</a>\n";
    }

    /*line break*/
    static String br(String id, String clasS, String content) {
        String string = "<br";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</br>\n";
    }


    /*emphasis*/
    static String em(String id, String clasS, String content) {
        String string = "<em";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</em>\n";
    }

    /*marking*/
    static String mark(String id, String clasS, String content) {
        String string = "<mark";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</mark>\n";
    }


    /*small font*/
    static String small(String id, String clasS, String content) {
        String string = "<small";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</small>\n";
    }


    /*inline generic container*/
    static String span(String id, String clasS, String content) {
        String string = "<span";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</span>\n";
    }


    /*strong*/
    static String strong(String id, String clasS, String content) {
        String string = "<strong";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content + "\n";
        return string + "\n</strong>\n";
    }

    /*time element represents specific period in time*/
    static String time(String id, String clasS, String datetime, String content) {
        String string = "<time";
        string += id(id);
        string += clasS(clasS);

        if (datetime.length() > 0)
            string += "datetime= " + datetime + " ";

        string += ">\n" + content + "\n";
        return string + "\n</time>\n";
    }


    //TODO Image and multimedia

    /*area that is clickable*/
    static String area(String id, String clasS, String alt, String download, String href, String hreflang, String rel, String target,
                       String shape, String media, String coords, String type, String content) {
        String string = "<area";
        string += id(id);
        string += clasS(clasS);
        if (alt.length() > 0)
            string += "alt= " + alt + " ";

        if (coords.length() > 0)
            string += "coords= " + coords + " ";

        if (download.length() > 0)
            string += "download= " + download + " ";

        if (href.length() > 0)
            string += "href= " + href + " ";

        if (media.length() > 0)
            string += "media= " + media + " ";

        if (hreflang.length() > 0)
            string += "hreflang= " + hreflang + " ";

        if (shape.length() > 0)
            string += "shape= " + shape + " ";

        if (rel.length() > 0)
            string += "rel= " + rel + " ";

        if (target.length() > 0)
            string += "target= " + target + " ";

        if (type.length() > 0)
            string += "type= " + type + " ";

        string += ">\n" + content + "\n";
        return string + "\n</area>\n";
    }

    /*audio*/
    static String audio(String id, String clasS, String autoplay, String controls, String crossorigin, String loop,
                        String muted, String preload, String src, String content) {
        String string = "<audio";
        string += id(id);
        string += clasS(clasS);

        if (controls.length() > 0)
            string += "controls= " + controls + " ";

        if (src.length() > 0) {
            string += "src= " + src + " ";
        }


        if (preload.length() > 0) {
            string += "preload= " + preload + " ";
        }

        if (muted.length() > 0) {
            string += "muted= " + muted + " ";
        }

        if (loop.length() > 0) {
            string += "loop= " + loop + " ";
        }

        if (crossorigin.length() > 0) {
            string += "alt= " + crossorigin + " ";
        }


        if (autoplay.length() > 0)
            string += "alt= " + autoplay + " ";


        string += ">\n" + content + "\n";
        return string + "\n</audio>\n";
    }


    /*image*/
    static String img(String id, String clasS, String alt, String crossorigin, String decoding, String height,
                      String ismap, String sizes, String src, String width, String usemap, String content) {
        String string = "<img ";
        string += id(id);
        string += clasS(clasS);

        if (alt.length() > 0)
            string += "alt= " + alt + " ";

        if (crossorigin.length() > 0)
            string += "crossorigin= " + crossorigin + " ";

        if (decoding.length() > 0)
            string += "decoding= " + decoding + " ";

        if (height.length() > 0)
            string += "height= " + height + " ";

        if (ismap.length() > 0)
            string += "ismap= " + ismap + " ";

        if (sizes.length() > 0)
            string += "sizes= " + sizes + " ";

        if (src.length() > 0)
            string += "src= " + src + " ";

        if (width.length() > 0)
            string += "width= " + width + " ";

        if (usemap.length() > 0)
            string += "usemap= " + usemap + " ";

        string += ">\n" + content + "\n";
        return string + "\n</img>\n";
    }


    /*image*/
    static String video(String id, String clasS, String autoplay, String controls, String crossorigin,
                        String height, String loop, String muted, String preload, String buffered, String src,
                        String width, String poster, String playsinline, String content) {
        String string = "<video ";
        string += id(id);
        string += clasS(clasS);

        if (autoplay.length() > 0)
            string += "autoplay= " + autoplay + " ";

        if (buffered.length() > 0)
            string += "buffered= " + buffered + " ";

        if (controls.length() > 0)
            string += "controls= " + controls + " ";

        if (crossorigin.length() > 0)
            string += "crossorigin= " + crossorigin + " ";

        if (loop.length() > 0)
            string += "loop= " + loop + " ";

        if (height.length() > 0)
            string += "height= " + height + " ";

        if (muted.length() > 0)
            string += "muted= " + muted + " ";

        if (preload.length() > 0)
            string += "preload= " + preload + " ";

        if (src.length() > 0)
            string += "src= " + src + " ";

        if (width.length() > 0)
            string += "width= " + width + " ";

        if (poster.length() > 0)
            string += "usemap= " + poster + " ";

        if (playsinline.length() > 0)
            string += "playsinline= " + playsinline + " ";

        string += ">\n" + content + "\n";
        return string + "\n</video>\n";
    }


    //TODO Scripting



    //TODO Table content


    //TODO Forms


    //TODO Interactive elements




    /**
     * Common attributes
     * */
    private static String checkTitle(String title)
    {
        String string = "";
        if (title.length()>0)
            string = " "+title+" ";

        return string;
    }


    /**
     * global attributes
     * */
    private static String clasS(String clas)
    {
        String string = "";
        if (clas.length()>0)
            string = " class="+clas+" ";

        return string;
    }

    private static String id(String id)
    {
        String string = "";
        if (id.length()>0)
            string = " id = "+id+" ";

        return string;
    }



}
