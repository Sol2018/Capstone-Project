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

    static String main(String id, String clasS, String content)
    {
        String string = "<header";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n</header>\n";
    }



    //TODO Text content


    //TODO Inline semantics


    //TODO Image and multimedia


    //TODO Embedded content


    //TODO Scripting


    //TODO Demarcating edits


    //TODO Table content


    //TODO Forms


    //TODO Interactive elements


    //TODO WebComponents


    /**
     * Common attributes
     * */
    static String checkTitle(String title)
    {
        String string = "";
        if (title.length()>0)
            string = " "+title+" ";

        return string;
    }


    /**
     * global attributes
     * */
    static String clasS(String clas)
    {
        String string = "";
        if (clas.length()>0)
            string = " class="+clas+" ";

        return string;
    }

    static String id(String id)
    {
        String string = "";
        if (id.length()>0)
            string = " id = "+id+" ";

        return string;
    }



}
