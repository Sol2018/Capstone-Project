import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

class XMLReader
{
    private File file;
    private Document document;

    XMLReader(File file)
    {
        this.file = file;

        try
        {
            //Creating a Document builder
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.normalize();
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the root element
     * helpful with determining type of metadata (is it metadata applied to all objects(e.g. gallery) or just one(e.g. image)?)
     * */
    org.w3c.dom.Element getRoot()
    {
        return document.getDocumentElement();
    }

    //TODO extract specific tags and agree on metadata tags
/*
    //returns specific attribute
    getAttribute("attributeName");

    //returns a Map (table) of names/values
    getAttributes();

    Examine sub-elements

//returns a list of subelements of specified name
getElementsByTagName("subelementName");

    //returns a list of all child nodes
    getChildNodes();*/
}
