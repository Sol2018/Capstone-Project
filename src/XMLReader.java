import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

class XMLReader
{
    private Document document;

    XMLReader(File file)
    {
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

    /**
     * Returns metadata by value
     * @param  name is the node's name
     * */
    String getValue(String name)
    {
        NodeList nodeList = document.getElementsByTagName(name);
        return nodeList.item(0).getTextContent();
    }
}
