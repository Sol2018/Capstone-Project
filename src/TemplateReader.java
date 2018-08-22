import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class TemplateReader
{
    ArrayList<String> templateElements = new ArrayList<>(0);
    private File templateFile = new File("Template.html");
    public TemplateReader()
    {
        try
        {
            Scanner scanner = new Scanner(templateFile);
            while(scanner.hasNext())
            {
              templateElements.add(scanner.next());
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Invalid template file");
        }
    }


    public ArrayList<String> generateConcreteHTML(String pageType)
    {
      String htmlData = "";
      String closer = "";
      for(int i =0; i<templateElements.size(); ++i)
      {
        htmlData += templateElements.get(i);
        if(templateElements.get(i).contains("navBar."+pageType))
        {
          htmlData += "href=\"active\">"+pageType.toUpperCase()+"</a>";
          ++i;
          continue;
        } else if(templateElements.get(i).contains("Showcase:"))
        {
          htmlData += pageType.toUpperCase()+"</h3>";
          ++i;
          continue;
        } else if (templateElements.get(i).contains("cat."+pageType))
        {
          htmlData += "href=\"#\"class=\"active\">Videos</a>";
          ++i;
          continue;
        } else if (templateElements.get(i).contains("col-md-10"))
        {
          while (i<templateElements.size())
          {
            closer+=templateElements.get(i);
          }
        }
      }

      ArrayList<String> arrayList = new ArrayList<>(0);
      arrayList.add(htmlData);
      arrayList.add(closer);

      return arrayList;
    }
}
