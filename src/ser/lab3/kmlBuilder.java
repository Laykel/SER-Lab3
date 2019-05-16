package ser.lab3;// inspirÃƒÂ© de
//https://examples.javacodegeeks.com/core-java/xml/jdom/create-xml-file-in-java-using-jdom-parser-example/

import java.io.*;
import java.util.ArrayList;



import org.jdom2.*;
import org.jdom2.output.*;

public class kmlBuilder {

    private static final String xmlFilePath = "src/newXMLfile.xml";

    public static void buildKml(ArrayList<Country> countries) {

        try {
            Namespace ns = Namespace.getNamespace("http://www.opengis.net/kml/2.2");
            Element kml = new Element("kml");

            Document document = new Document(kml);
            Element documentTag= new Element("Document");
            kml.addNamespaceDeclaration(ns);

            Element style=new Element("Style");
            style.setAttribute("id","orange-5px");
            Element lineStyle= new Element("LineStyle");
            lineStyle.addContent(new Element("color").setText("ff00aaff"));
            lineStyle.addContent(new Element("width").setText("5"));
            style.addContent(lineStyle);
            documentTag.addContent(style);



            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(document, new FileWriter(xmlFilePath));

            System.out.println("XML File was created successfully!");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Element> elementFromCountry(Country country){

        ArrayList<Element> elements= new ArrayList<>();
        ArrayList<ArrayList<Coordinate>> coordinateSet=country.getCoordinates();

        for(int i= 0; i <coordinateSet.size();i++){
            Element placemark= new Element("Placemark");
            placemark.addContent(new Element("name").setText(country.getName()));
            placemark.addContent(new Element("styleUrl").setText("#orange-5px"));

            Element lineString =new Element("LineString");
            lineString.addContent(new Element("tessellate").setText("1"));
            String coordinatesStr="";
            for(int j = 0; j <coordinateSet.get(i).size();j++){
                Coordinate c= coordinateSet.get(i).get(j);
                coordinatesStr+= c.toString()+" ";
            }
            placemark.addContent(new Element("LineString"));
        }


        return elements;
    }
}
