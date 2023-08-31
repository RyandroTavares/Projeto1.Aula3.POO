package Exemplo1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Exemplo1 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");

            int count = nodeList.getLength();
            System.out.println("Número de passageiros: " + count + "\n");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String idade = element.getElementsByTagName("idade").item(0).getTextContent();
                    String numeroDoTicket = element.getElementsByTagName("numeroDoTicket").item(0).getTextContent();
                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = element.getElementsByTagName("destino").item(0).getTextContent();
                    System.out.println("Nome: " + nome);
                    System.out.println("Idade: " + idade);
                    System.out.println("Número do ticktet: " + numeroDoTicket);
                    System.out.println("Origem: " + origem);
                    System.out.println("Destino: " + destino + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}