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
              String n = scanner.next();
              System.out.println(n);
              templateElements.add(n);
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
        htmlData += templateElements.get(i)+"\n";
        if(templateElements.get(i).contains("navBar."+pageType))
        {
          htmlData += "href=\"active\">"+pageType.substring(0,1).toUpperCase()+pageType.substring(1)+"</a>"+"\n";
          ++i;
          continue;
        } else if(templateElements.get(i).contains("Showcase:"))
        {
          htmlData += pageType.toUpperCase()+"</h3>"+"\n";
          ++i;
          continue;
        } else if (templateElements.get(i).contains("cat."+pageType))
        {
          htmlData += "href=\"#\"class=\"active\">"+pageType.substring(0,1).toUpperCase()+pageType.substring(1)+"</a>"+"\n";
          i+=2;
          continue;
        } else if (templateElements.get(i).contains("col-md-10"))
        {
          i++;
          while (i<templateElements.size())
          {
            closer+=templateElements.get(i)+"\n";
            i++;
          }
        }
      }

      ArrayList<String> arrayList = new ArrayList<>(0);
      arrayList.add(htmlData);
      arrayList.add(closer);

      return arrayList;
    }
}
