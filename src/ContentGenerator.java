import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ContentGenerator
{
  private StringBuilder imageContent = new StringBuilder();
  private StringBuilder documentContent = new StringBuilder();
  private StringBuilder videoContent = new StringBuilder();
  private StringBuilder audioContent = new StringBuilder();
  private XMLReader xmlReader;
  private ArrayList<File> metaDataFiles = new ArrayList<>(0);

  /**
  * @param args is the directory provided by the user
  */
  public ContentGenerator(String[] args)
  {
      findXMLs(args[0]);
  }

  /**
  * Recursively finds all XML files in the provided directory and adds them to the metaDataFiles ArrayList
  * @param arg is the current directory
  * */
  private void findXMLs(String arg)
  {
    //current directory
    File file = new File(arg);

    //search for all xml files
    File[] files = file.listFiles();

    assert files != null;
    for(File f: files)
    {
      if (f.getName().length()>3)
      {
        if ((f.getName().substring(f.getName().length()-4,f.getName().length())).compareTo(".xml")==0)
        {
          metaDataFiles.add(f);
        }
      }
      if (f.isDirectory())
      {
        findXMLs(f.getAbsolutePath());
      }
    }
  }

  /**
  * Read image content from xml fiels and write it to String Builder
  */
  public void generateImageContent()
  {
      for (File file : metaDataFiles)
      {
          xmlReader = new XMLReader(file);

          if (xmlReader.getRoot().getTagName().compareTo("image") == 0)
          {
            //TODO load image, parse this into a template
            imageContent.append("<div class=\"item\"><a target=\"_blank\" href=" + xmlReader.getValue("src") + ">");
            imageContent.append("<img src=" + xmlReader.getValue("src") +"> </a>");
            imageContent.append("<div class=\"desc\"  >" + xmlReader.getValue("description") + "</div></div>\n");
          } else if (xmlReader.getRoot().getTagName().compareTo("gallery") == 0)
          {
            //TODO load a list of images
            //load all files in directory
            File[] files = new File(xmlReader.getValue("src")).listFiles();

            assert files != null;
            for (File file1 : files)
            {
              //TODO load image
              if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
              {
                //TODO load image, parse this into a template
                imageContent.append("<div class=\"item\"><a target=\"_blank\" href=" + file1.getPath() + ">");
                imageContent.append("<img src=" + file1.getPath() +"> </a>");
                imageContent.append("<div class=\"desc\" >" + xmlReader.getValue("description") + "</div></div>\n");
              }
            }
          }
        }
    }

    public void generateDocumentContent()
    {
      documentContent.append("<ul>\n");
      for (File file : metaDataFiles)
      {
          xmlReader = new XMLReader(file);

          if (xmlReader.getRoot().getTagName().compareTo("document") == 0)
          {
            //TODO load documents, parse this into a template
            documentContent.append("<li>\n <strong>Title:</strong>");
            documentContent.append("<a target=\"_blank\" src = "+xmlReader.getValue("src")+" href="+xmlReader.getValue("src")+">");
            documentContent.append(xmlReader.getValue("name") + "</a> <br> <strong>Contributors: </strong>");
            documentContent.append(xmlReader.getValue("author") + "<br> <strong>Year: </strong> ");
            documentContent.append("<strong>"+xmlReader.getValue("date")+ "</strong> </li>");
          } else if (xmlReader.getRoot().getTagName().compareTo("docLib") == 0)
          {
            //TODO load a list of docuemts
            File[] files = new File(xmlReader.getValue("src")).listFiles();

            assert files != null;
            for (File file1 : files)
            {
              //TODO load docs
              if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
              {
                //TODO load doc, parse this into a template
                documentContent.append("<li>\n <strong>Title:</strong>");
                documentContent.append("<a target=\"_blank\" src="+file1.getPath()+" href="+file1.getPath()+">");
                documentContent.append(xmlReader.getValue("name") + "</a> <br> <strong>Contributors: </strong>");
                documentContent.append(xmlReader.getValue("author") + "<br> <strong>Year: </strong> ");
                documentContent.append("<strong>"+xmlReader.getValue("date")+ "</strong> </li>");
              }
            }
          }
        }
        documentContent.append("</ul>\n");
    }

    /**
    * Read video content from xml fiels and write it to String Builder
    */
    public void generateVideoContent()
    {for (File file : metaDataFiles)
    {
        xmlReader = new XMLReader(file);

        if (xmlReader.getRoot().getTagName().compareTo("vid") == 0)
        {
          //TODO load image, parse this into a template
          videoContent.append("<div id=\"vid\"><a target=\"_blank\" href=" + xmlReader.getValue("src") + ">");
          videoContent.append("<video width=425 height=344 src=" + xmlReader.getValue("src") +"> </video>");
          videoContent.append("<div class=\"desc\"  >" + xmlReader.getValue("description") + "</div></div>\n");
        } else if (xmlReader.getRoot().getTagName().compareTo("vidLib") == 0)
        {
          //TODO load a list of images
          //load all files in directory
          File[] files = new File(xmlReader.getValue("src")).listFiles();
          assert files != null;
          for (File file1 : files)
          {
            //TODO load image
            if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
            {
              //TODO load image, parse this into a template
              videoContent.append("<div id=\"vid\"><a target=\"_blank\" href=" + file1.getPath() + ">");
              videoContent.append("<video width=300 height=350 src=" + file1.getPath() +"> </video>");
              videoContent.append("<div class=\"desc\" >" + xmlReader.getValue("description") + "</div></div>\n");
            }
          }
        }
      }
      }


      /**
      * Read video content from xml fiels and write it to String Builder
      */
      public void generateAudioContent()
      {for (File file : metaDataFiles)
      {
          xmlReader = new XMLReader(file);

          if (xmlReader.getRoot().getTagName().compareTo("audio") == 0)
          {
            //TODO load image, parse this into a template
            audioContent.append("<div id=\"item\"><a target=\"_blank\" href=" + xmlReader.getValue("src") + ">");
            audioContent.append("<audio controls src=" + xmlReader.getValue("src") +"> </audio>");
            audioContent.append("<div class=\"desc\"  >" + xmlReader.getValue("description") + "</div></div>\n");
          } else if (xmlReader.getRoot().getTagName().compareTo("audioLib") == 0)
          {
            //TODO load a list of images
            //load all files in directory
            File[] files = new File(xmlReader.getValue("src")).listFiles();
            assert files != null;
            for (File file1 : files)
            {
              //TODO load image
              if ((file1.getName().substring(file1.getName().length() - 4, file1.getName().length())).compareTo(".xml") != 0)
              {
                //TODO load image, parse this into a template
                audioContent.append("<div id=\"item\"><a target=\"_blank\" href=" + file1.getPath() + ">");
                audioContent.append("<audio controls src=" + file1.getPath() +"> </audio>");
                audioContent.append("<div class=\"desc\" >" + xmlReader.getValue("description") + "</div></div>\n");
              }
            }
          }
        }
        }


    /**
     * Writes text to a new html file
     * @param name is the name of the html file
     * @param text is the content of the file
     */
    public void writeHTMLtoFile(String text, String name)
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


    /**
    * Get image content in string format
    */
    public String getImages()
    {
      return imageContent.toString();
    }

    /**
    * Get image content in string format
    */
    public String getDocuments()
    {
      return documentContent.toString();
    }


    /**
    * Get video content in string format
    */
    public String getVideos()
    {
      return videoContent.toString();
    }

    /**
    * Get video content in string format
    */
    public String getAudio()
    {
      return audioContent.toString();
    }

}
