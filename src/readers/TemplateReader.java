package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TemplateReader
{
    private ArrayList<String> templateElements = new ArrayList<>(0);

    /**
     * Constructor initializes template by loading the template strings into an array list
     * @param file is the name of template file to be loaded */
    public TemplateReader(String file)
    {
        try
        {
            Scanner scanner = new Scanner(new File(file));
            while(scanner.hasNext())
            {
              templateElements.add(scanner.next());
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Invalid template file");
        }
    }


    /**
     * Sets up template to fit the type of data being presented on the page
     * @param pageType indicates what kind of page is generated from the template
     * @return arrayList is the template page split into two, to allow insertion of data.
     * */
    public ArrayList<String> setUpPageTemplate(String pageType)
    {
        StringBuilder upperPage = new StringBuilder();
        //digital objects are slotted in between the upper and lower page
        StringBuilder lowerPage = new StringBuilder();

        for(int i =0; i<templateElements.size(); ++i)
        {
            upperPage.append(templateElements.get(i)).append("\n");

            //activate navigational element of pageType
            if(templateElements.get(i).contains("navBar-"+pageType))
            {
                upperPage.append("class=\"active\">").append(pageType.substring(0, 1).toUpperCase()).append(pageType.substring(1)).append("</a>").append("\n");
                ++i;

            //write page title on header
            } else if(templateElements.get(i).contains("Showcase:"))
            {
                upperPage.append(pageType.toUpperCase()).append("</h3>").append("\n");
                ++i;

            //activate category elements of pageType
            } else if (templateElements.get(i).contains("cat-"+pageType))
            {
                upperPage.append("class=\"active\">").append(pageType.substring(0, 1).toUpperCase()).append(pageType.substring(1)).append("</a>").append("\n");
                i+=2;


            //
            }else if (templateElements.get(i).contains("onclick=\"javascript:window.location.href="))
            {
                upperPage.append("'"+pageType+"'");
                i++;
            //split template into two pages
            } else if (templateElements.get(i).contains("col-md-10"))
            {
                i++;
                while (i<templateElements.size())
                {
                    lowerPage.append(templateElements.get(i)).append("\n");
                    i++;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(upperPage.toString(), lowerPage.toString()));
    }
}