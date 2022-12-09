package ejercicio7XML;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PruebaJaviXML {

    public static void main(String args[]) throws ParserConfigurationException, SAXException {

        try {

            File file = new File("C:\\Users\\Leire\\Desktop\\agenda_visitas.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(file);
            document.getDocumentElement().normalize();

            System.out.println("Ejercicio 7 " + document.getDocumentElement().getNodeName() + ":");
            NodeList nList = document.getElementsByTagName("cita");
            NodeList nList2 = document.getElementsByTagName("ubicacion");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Node nNode2 = nList2.item(temp);
                System.out.println("");
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Cita - id: " + eElement.getAttribute("id"));
                    System.out.println("Comercial: " + eElement.getAttribute("comercial"));
                    System.out.println("Fecha: " + eElement.getElementsByTagName("fecha").item(0).getTextContent());
                    System.out.println("Asunto: " + eElement.getElementsByTagName("asunto").item(0).getTextContent());
                    System.out.println("Descripció: " + eElement.getElementsByTagName("descripcion").item(0).getTextContent());
                }
                if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement2 = (Element) nNode2;
                    System.out.println("Dirección: " + eElement2.getElementsByTagName("direccion").item(0).getTextContent());
                    System.out.println("Numero: " + eElement2.getElementsByTagName("numero").item(0).getTextContent());
                    System.out.println("Planta: " + eElement2.getElementsByTagName("planta").item(0).getTextContent());
                    System.out.println("Detalle: " + eElement2.getElementsByTagName("detalles").item(0).getTextContent());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
