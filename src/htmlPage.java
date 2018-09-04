import Order.*;
import element.htmlElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is responsible for the creation and indexing of html pages
 * */
class htmlPage
{
    private static final int limit = 9; //objects per page, also number
    private static final int paginationlimit = 5;//for predictable behavior use odd pages
    private ArrayList<String> templatePage;
    private List<htmlElement> elements;


    htmlPage(ArrayList<String> templatePage, List<htmlElement> elements, String type)
    {
        this.templatePage = templatePage;
        this.elements = elements;

        pagination("default", type);

        elements.sort(new authorOrder());
        pagination("author", type);

        elements.sort(new nameOrder());
        pagination("name", type);

        elements.sort(new locationOrder());
        pagination("location", type);

        elements.sort(new dateOrder());
        pagination("date", type);

        elements.sort(new sizeOrder());
        pagination("size", type);

    }

    /**
     * Pagination and limiting number of objects per page
     * */
    private void pagination(String order, String pageType)
    {
        int objectIndex = 0;

        //determine number of pages given object limits
        int pages = (elements.size()/limit);
        if (pages%limit!=0)
            pages+=1;
        if (pages == 0)
            pages += 1;
        for (int i = 0; i<pages; ++i)
        {
            StringBuilder s = new StringBuilder(templatePage.get(0));//top part of template

            //adding objects to page
            for (int j = 0; j < limit && objectIndex < elements.size(); j++)
            {
                s.append("\n");
                s.append(elements.get(objectIndex).toString());

                ++objectIndex;
            }
            s.append("</div> \n<div class=\"pagination\">\n");

            //implementing pagination
            if (pages<=paginationlimit) {
                paginationLoop(i, 0, pages - 1, s, order, pageType);
            } else if (i <= paginationlimit / 2) {
                paginationLoop(i, 0, paginationlimit - 1, s, order, pageType);
                edgePagination(pages - 1, "lastPage", s, order, pageType);
            } else if (i + paginationlimit / 2 >= pages - 1) {
                edgePagination(0, "firstPage", s, order, pageType);
                paginationLoop(i, pages - paginationlimit, pages - 1, s, order, pageType);
            } else {
                edgePagination(0, "firstPage", s, order, pageType);
                int num = i - paginationlimit / 2;
                paginationLoop(i, num, i + paginationlimit / 2, s, order, pageType);
                edgePagination(pages - 1, "lastPage", s, order, pageType);
            }


            s.append(templatePage.get(1));
            writeHTMLtoFile(s.toString(), pageType + i + "_" + order + ".html");
        }
    }

    private void paginationLoop(int i, int a, int b, StringBuilder s, String type, String page)
    {
        for (int k = a; k <= b; k++) {
            if (k == i)//mark current page as active
            {
                s.append("<a href=\"#\" class=\"active\">");
            } else {
                s.append("<a href=\"" + page + k + "_" + type + ".html" + "\">");
            }
            s.append(k).append("</a>\n");
        }
    }

    private void edgePagination(int i, String name, StringBuilder s, String type, String page)
    {
        s.append("<a href=\"" + page + (i) + "_" + type + ".html" + "\">");
        s.append(name).append("</a>\n");
    }


    /**
     * Writes text to a new html file
     * @param name is the name of the html file
     * @param text is the content of the file
     */
    private void writeHTMLtoFile(String text, String name)
    {
        BufferedWriter output = null;
        try {
            File file = new File(name);
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
