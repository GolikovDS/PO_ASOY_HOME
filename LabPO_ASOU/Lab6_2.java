package LabPO_ASOU;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * Created by Дмитрий on 14.02.2015.
 */
public class Lab6_2 {
    static List<Address> data = new ArrayList<Address>();
    static int counterNode;
    public static void main(String[] args) {

        data = startLoad();
        counterNode = data.size();

        Scanner in = new Scanner(System.in);
        int guess;
        UserInterface ui = new UserInterface();
        while (true) {
            ui.mainMenu(getCount());
            guess = in.nextInt();
            switch (guess) {

                case 1:
                    add(ui.enterNameMenu()); break;
                case 2:
                    ui.searchNode(data); break;
                case 3:
                    printAllNode(); break;
                case 4:
                    System.out.println("Введите индек элемента для удаления: ");
                    delete(in.nextInt() - 1);
                    break;
                case 5:
                    System.out.println("Введите индек элемента для изменения: ");
                    change(in.nextInt() - 1);
                    break;
                case 6:
                    saveAndExit(); break;
                case 0:
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new Lab6_2_GUI();
                        }
                    });

                default:
                    System.out.println("Error namb");

            }
        }
    }

    static void  saveAndExit(){
        WriteXMLFile writeXMLFile = new WriteXMLFile();
        writeXMLFile.writeXML(data, counterNode);
        System.exit(0);
    }

    static List<Address> startLoad (){
        WriteXMLFile writeXMLFile = new WriteXMLFile();
        return writeXMLFile.readXML();
    }

    static void add (Address newEntry){
        counterNode++;
        data.add(newEntry);
    }

    static int getCount(){
        return counterNode;
    }

    static void printAllNode(){
        for (int i = 0; i < data.size(); i++){
            System.out.println("************Запись №" + Integer.toString(i + 1));
            System.out.println("Имя: " + data.get(i).getName());
            System.out.println("Телефон: " + data.get(i).getPhone());
            System.out.println("E-mail: " + data.get(i).getEmail());
            System.out.println("**************************************");
        }
    }

    static void delete(int index){
        counterNode--;
        data.remove(index);
    }

    static void change (int index){
        Scanner in = new Scanner(System.in);
        String name, phone, email;
        System.out.println("Введите новое имя:");
        name = in.nextLine();
        System.out.println("Введите новый телефон:");
        phone = in.nextLine();
        System.out.println("Введите новую почту:");
        email = in.nextLine();
        Address changeNode = new Address(name, phone, email);
        data.set(index, changeNode);
        System.out.println("Прошло изменение:");
    }

}

class UserInterface {
    public void mainMenu(int counterNode){
        System.out.println("******************************************************\n" +
                        "*       Главное меню                                 *\n" +
                        "******************************************************\n" +
                        "Всего записей: " + Integer.toString(counterNode) + "\n\n" +
                        "  1-Добавить запись\n" +
                        "  2-Поиск записи   \n" +
                        "  3-Вывести все записи   \n" +
                        "  4-Удалить запись   \n" +
                        "  5-Изменить запись    \n" +
                        "  6-Выход   \n"

        );
    }

    public Address enterNameMenu (){

        String name, phone, email;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите новое имя:");
        name = in.nextLine();
        System.out.println("Введите новый телефон:");
        phone = in.nextLine();
        System.out.println("Введите новую почту:");
        email = in.nextLine();
        Address newNode = new Address(name, phone, email);
        return newNode;

    }

    public void searchNode(List <Address> node){
        //Address searchNode = new Address();
        Scanner in = new Scanner(System.in);
        System.out.println("Для поиска по имени нажмите 1\nДля поиска по индексу нажмите 2 ");

        int nambSearch = in.nextInt();
        if (nambSearch == 1){
            System.out.println("Введите имя: ");
            Scanner inL = new Scanner(System.in);
            String searchName = inL.nextLine();
           for (int i = 0; i < node.size(); i++ ){
                if(node.get(i).getName().toString().equals(searchName))
                    System.out.println("Найдено: " + node.get(i).getName());
            }
            System.out.println("Поиск завершон");

        }else if(nambSearch == 2) {
            System.out.println("Введите индекс: ");
            System.out.println(node.get(in.nextInt()).getName());
        } else {

            System.out.println("Не верно введено значение");
        }


    }
}

class WriteXMLFile {

    public void writeXML(List<Address> writeDate, int counterNode) {

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

            System.out.println("File saved!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public List<Address> readXML(){
        List<Address> readingDate = new ArrayList<Address>();
        try {

            File fXmlFile = new File("file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("node");

            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

               // System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Номер записи : " + eElement.getAttribute("namb"));
                    System.out.println("Имя : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Телефон : " + eElement.getElementsByTagName("phone").item(0).getTextContent());
                    System.out.println("E-mail : " + eElement.getElementsByTagName("email").item(0).getTextContent());

                    Address newNaode = new Address(eElement.getElementsByTagName("name").item(0).getTextContent(),
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

class Address {

    Address(String sName, String sPhone, String sEmail){
        name = sName;
        phone = sPhone;
        email = sEmail;
    }
    protected String name;
    protected String phone;
    protected String email;
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}

}