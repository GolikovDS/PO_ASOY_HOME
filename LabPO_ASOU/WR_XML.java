package LabPO_ASOU;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public class WR_XML {

    public void writeXML(List<Address_6_2> writeDate, int counterNode) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("bookpone");
            doc.appendChild(rootElement);
// staff elements
            for (int i = 0; i < counterNode; i++) {
                Element node = doc.createElement("node");
                rootElement.appendChild(node);
// set attribute to staff element
                Attr attr = doc.createAttribute("namb");
                attr.setValue(Integer.toString(i));
                node.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                // firstname elements
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(writeDate.get(i).getName()));
                node.appendChild(name);

                // lastname elements
                Element phone = doc.createElement("phone");
                phone.appendChild(doc.createTextNode(writeDate.get(i).getPhone()));
                node.appendChild(phone);

                // nickname elements
                Element email = doc.createElement("email");
                email.appendChild(doc.createTextNode(writeDate.get(i).getEmail()));
                node.appendChild(email);

            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            //System.out.println("File saved!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public List<Address_6_2> readXML(){
        List<Address_6_2> readingDate = new ArrayList<Address_6_2>();
        try {

            File fXmlFile = new File("file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("node");

//            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                // System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

//                    System.out.println("Номер записи : " + eElement.getAttribute("namb"));
//                    System.out.println("Имя : " + eElement.getElementsByTagName("name").item(0).getTextContent());
//                    System.out.println("Телефон : " + eElement.getElementsByTagName("phone").item(0).getTextContent());
//                    System.out.println("E-mail : " + eElement.getElementsByTagName("email").item(0).getTextContent());

                    Address_6_2 newNaode = new Address_6_2(eElement.getElementsByTagName("name").item(0).getTextContent(),
                            eElement.getElementsByTagName("phone").item(0).getTextContent(),
                            eElement.getElementsByTagName("email").item(0).getTextContent());
                    readingDate.add(i, newNaode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readingDate;
    }
}
