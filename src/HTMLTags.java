//follows MDN web docs
public class HTMLTags
{
    /**
     * Main Root
     * */
    static String openHTML()
    {
        return "\n\t<!DOCTYPE html>\n" +
                "\t<html lang=\"en\">\n";
    }

    static String closeHTML()
    {
        return "\n\t</html>\n";
    }


    /**
     * Document metadata
     * */
    //TODO check if changing the parameters to just String attribute is better than enumerating all
    /*specifies relationship between the current document and an external source*/
    static String link(String as, String crossorigin, String href, String hreflang,
                       String media, String rel, String sizes, String title, String type)
    {
        String string = "\n\t<link ";

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
        return "\n\t<meta charset=\"utf-8\">\n";
    }

    /*contains style information for a document or part of it*/
    static String style(String type, String media, String nonce, String title, String content)
    {
        String string = "\n\t<style ";

        if(type.length()>0)
            string+= "type= " + type +" ";

        if(media.length()>0)
            string+= "media= " + media +" ";

        if(nonce.length()>0)
            string+= "media= " + nonce +" ";

        string += checkTitle(title);

        string += ">\n"+ content +"\n";


        return string + "\t</style>\n";
    }

    /*defines the document's title that is shown in a browser's title bar*/
    static String Pagetitle(String title)
    {
        return "\n\t<title>\n" + title + "\n\t</title>\n";
    }


    /**
     * Sectioning root
     * */
    static String head(String content)
    {
        return "\n\t<head>\n" + content + "\n\t</head>\n";
    }

    static String body(String content)
    {
        return "\n\t<body>\n" + content + "\n\t</body>\n";
    }

    //TODO Content sectioning refactoring-if necessary
    /*represents a self-contained composition*/
    static String article(String id, String clasS, String content)
    {
        String string = "\t<article";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</article>\n";
    }

    /*represents indirectly related content*/
    static String aside(String id, String clasS, String content)
    {
        String string = "\t<aside";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</aside>\n";
    }

    static String footer(String id, String clasS, String content)
    {
        String string = "\t<footer";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</footer>\n";
    }

    /*represents introductory content*/
    static String header(String id, String clasS, String content)
    {
        String string = "\t<header";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</header>\n";
    }

    static String sectionHeader(String id, String clasS, int level,  String content)
    {
        String string = "\t<h" + level;
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</h" + level + ">\n";
    }

    /*represents a multi-level heading for a section of a document*/
    static String hGroup(String id, String clasS, String content)
    {
        String string = "\t<hGroup";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</hGroup>\n";
    }

    /*represents dominant content*/
    static String main(String id, String clasS, String content) {
        String string = "\t<main";
        string += id(id);
        string += clasS(clasS);
        string += ">\n"+ content +"\n";
        return string + "\n\t</main>\n";
    }

    /*represents a section of a page whose purpose is to provide navigation links*/
    /*represents dominant content*/
    static String nav(String id, String clasS, String content) {
        String string = "\t<nav";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</nav>\n";
    }


    /*represents a standalone section*/
    static String section(String id, String clasS, String content) {
        String string = "\t\t<section";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</section>\n";
    }


    /*Conent Division Tag*/
    static String div(String id, String clasS, String content) {
        String string = "\n\t<div ";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</div>\n";
    }


    //TODO Text content
    /*Description details*/
    static String dd(String id, String clasS, String content) {
        String string = "\t<dd";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</dd>\n";
    }

    /*Description list*/
    static String dl(String id, String clasS, String content) {
        String string = "\t<dl";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</dl>\n";
    }

    /*Description term*/
    static String dt(String id, String clasS, String content) {
        String string = "\t<dt";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</dt>\n";
    }


    /*figure caption*/
    static String figcaption(String id, String clasS, String content) {
        String string = "\t<figcaption";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</figcaption>\n";
    }

    /*figure*/
    static String figure(String id, String clasS, String content) {
        String string = "\t<figure";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</figure>\n";
    }


    /*Horizontal rule*/
    static String hr(String id, String clasS, String content) {
        String string = "\t<hr";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</hr>\n";
    }


    /*Ordered list*/
    static String ol(String id, String clasS, String reversed, String type, String start, String content) {
        String string = "\t<ol";
        string += id(id);
        string += clasS(clasS);

        if (reversed.length() > 0)
            string += "reversed= " + reversed + " ";

        if (type.length() > 0)
            string += "type= " + type + " ";

        if (start.length() > 0)
            string += "start= " + start + " ";

        string += ">\n" + content;
        return string + "\n\t</ol>\n";
    }


    /*paragraph*/
    static String p(String id, String clasS, String content) {
        String string = "\t<p";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</p>\n";
    }


    /*unordered list*/
    static String ul(String id, String clasS, String content) {
        String string = "\t<ul";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</ul>\n";
    }

    //TODO important for ordering lists, suggestion: make an index html that values object according to the ordering
    // criteria and use that for ordering
    /*list item*/
    static String li(String id, String clasS, String value, String content) {
        String string = "\t<li ";
        string += id(id);
        string += clasS(clasS);

        if (value.length() > 0)
            string += "value= " + value + " ";

        string += ">\n" + content;
        return string + "\n\t</li>\n";
    }



    //TODO Inline semantics
    /*anchor element*/
    static String a(String id, String clasS, String download, String href, String hreflang, String rel, String target,
                    String type, String content) {
        String string = "\t<a ";
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

        string += ">\n" + content;
        return string + "\n\t</a>\n";
    }

    /*line break*/
    static String br(String id, String clasS, String content) {
        String string = "\t<br";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</br>\n";
    }


    /*emphasis*/
    static String em(String id, String clasS, String content) {
        String string = "\t<em";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</em>\n";
    }

    /*marking*/
    static String mark(String id, String clasS, String content) {
        String string = "\t<mark";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</mark>\n";
    }


    /*small font*/
    static String small(String id, String clasS, String content) {
        String string = "\t<small";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</small>\n";
    }


    /*inline generic container*/
    static String span(String id, String clasS, String content) {
        String string = "\t<span";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</span>\n";
    }


    /*strong*/
    static String strong(String id, String clasS, String content) {
        String string = "\t<strong";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</strong>\n";
    }

    /*time element represents specific period in time*/
    static String time(String id, String clasS, String datetime, String content) {
        String string = "\t<time";
        string += id(id);
        string += clasS(clasS);

        if (datetime.length() > 0)
            string += "datetime= " + datetime + " ";

        string += ">\n" + content;
        return string + "\n\t</time>\n";
    }


    //TODO Image and multimedia

    /*area that is clickable*/
    static String area(String id, String clasS, String alt, String download, String href, String hreflang, String rel, String target,
                       String shape, String media, String coords, String type, String content) {
        String string = "\t<area";
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

        string += ">\n" + content;
        return string + "\n\t</area>\n";
    }

    /*audio*/
    static String audio(String id, String clasS, String autoplay, String controls, String crossorigin, String loop,
                        String muted, String preload, String src, String content) {
        String string = "\t<audio";
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


        string += ">\n" + content;
        return string + "\n\t</audio>\n";
    }


    /*image*/
    static String img(String id, String clasS, String alt, String crossorigin, String decoding, String height,
                      String ismap, String sizes, String src, String width, String usemap, String content) {
        String string = "\t<img ";
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

        string += ">\n" + content;
        return string + "\n\t</img>\n";
    }


    /*image*/
    static String video(String id, String clasS, String autoplay, String controls, String crossorigin,
                        String height, String loop, String muted, String preload, String buffered, String src,
                        String width, String poster, String playsinline, String content) {
        String string = "\t<video ";
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

        string += ">\n" + content;
        return string + "\n\t</video>\n";
    }


    static String svg(String id, String clasS, String height, String preserveAspectRatio, String viewBox,
                      String width, String x, String y, String content) {
        String string = "\t<label ";
        string += id(id);
        string += clasS(clasS);

        if (height.length() > 0)
            string += "height= " + height + " ";

        if (preserveAspectRatio.length() > 0)
            string += "preserveAspectRatio= " + preserveAspectRatio + " ";

        if (viewBox.length() > 0)
            string += "viewBox= " + viewBox + " ";

        if (width.length() > 0)
            string += "width= " + width + " ";

        if (x.length() > 0)
            string += "x= " + x + " ";

        if (y.length() > 0)
            string += "y= " + y + " ";


        string += ">\n" + content;
        return string + "\n\t</label>\n";
    }


    //TODO Scripting




    //TODO Table content


    //TODO Forms
    static String form(String id, String clasS, String accept_charset, String action, String autocomplete, String enctype,
                       String method, String name, String novalidate, String target, String content) {
        String string = "\t<form ";
        string += id(id);
        string += clasS(clasS);

        if (accept_charset.length() > 0)
            string += "accept_charset= " + accept_charset + " ";

        if (action.length() > 0)
            string += "action= " + action + " ";

        if (autocomplete.length() > 0)
            string += "autocomplete= " + autocomplete + " ";

        if (enctype.length() > 0)
            string += "enctype= " + enctype + " ";

        if (method.length() > 0)
            string += "method= " + method + " ";

        if (name.length() > 0)
            string += "name= " + name + " ";

        if (novalidate.length() > 0)
            string += "novalidate= " + novalidate + " ";

        if (target.length() > 0)
            string += "target= " + target + " ";


        string += ">\n" + content;
        return string + "\n\t</form>\n";
    }

    static String label(String id, String clasS, String FOR, String form, String content) {
        String string = "\t<label ";
        string += id(id);
        string += clasS(clasS);

        if (FOR.length() > 0)
            string += "for= " + FOR + " ";

        if (form.length() > 0)
            string += "form= " + form + " ";


        string += ">\n" + content;
        return string + "\n\t</label>\n";
    }

    /*form input*/
    static String input(String id, String clasS, String attribute, String content) {
        String string = "\t<input ";
        string += id(id);
        string += clasS(clasS);
        string += attribute;
        string += ">\n" + content;
        return string + "\n";
    }



    //TODO Interactive elements
    static String details(String id, String clasS, String open, String content) {
        String string = "\t<details ";
        string += id(id);
        string += clasS(clasS);

        if (open.length() > 0)
            string += "open = " + open + " ";
        string += ">\n" + content;
        return string + "\n\t</details>\n";
    }


    static String summary(String id, String clasS, String content) {
        String string = "\t<summary ";
        string += id(id);
        string += clasS(clasS);
        string += ">\n" + content;
        return string + "\n\t</summary>\n";
    }





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
