package hu.domparse.ICDOQV.DOMRead;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Domread {
    public static void main(String[] args) {

        //Uj DocumentBuilder letrehozasa
        //XML fajlbol dokumentum letrehozasa
        File xmlFile = new File("XML_ICDOQV.xml");
        Document doc = null;
        doc = introduceFile(doc, xmlFile);

        //Teszteljuk, hogy lefut-e, ha igen kiirjuk
        if (doc != null) {
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } else {
            System.out.println("A doc null ertek!");
        }
        NodeList myList = doc.getDocumentElement().getChildNodes();
        String indent = "";
        listData(myList, indent);

    }

    public static Document introduceFile(Document doc, File xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Domread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }

    public static void listData(NodeList thisList, String indent) {
        indent += "\t";
        if (thisList != null) {
            for (int i = 0; i < thisList.getLength(); i++) {
                Node thisNode = thisList.item(i);
                if (thisNode.getNodeType() == Node.ELEMENT_NODE && !thisNode.getTextContent().trim().equals("")) {
                    System.out.println(indent + "{" + thisNode.getNodeName() + "}:");

                    NodeList newList = thisNode.getChildNodes();
                    listData(newList, indent);
                } else if (thisNode instanceof Text) {
                    String value = thisNode.getNodeValue().trim();
                    if (value.equals("")) {
                        continue;
                    }
                    System.out.println(indent + "-" + thisNode.getTextContent() + "-");
                }
            }
        }
    }
}
