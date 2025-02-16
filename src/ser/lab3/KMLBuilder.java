/**
 * SER - Laboratoire 3 : Parsing Geojson to KML
 * Fichier : GeoJSONParser.java
 * Auteurs : Marion Dutu Launay, Luca-Manu Reis De Carvalho, Luc Wachter
 * Date : 19 mai 2019
 */

package ser.lab3;

import java.io.*;
import java.util.ArrayList;

import org.jdom2.*;
import org.jdom2.output.*;

/**
 * Convert stored objects to KML
 * <p>
 * Sources: https://examples.javacodegeeks.com/core-java/xml/jdom/create-xml-file-in-java-using-jdom-parser-example/
 */
public class KMLBuilder {
    public static void buildKml(ArrayList<Country> countries, String dest) {
        try {
            Namespace ns = Namespace.getNamespace("http://www.opengis.net/kml/2.2");
            Element kml = new Element("kml");

            Document document = new Document(kml);

            Element documentTag = new Element("Document");
            kml.setNamespace(ns);


            Element style = new Element("Style");
            style.setAttribute("id", "outline-1px");
            Element lineStyle = new Element("LineStyle");
            lineStyle.addContent(new Element("color").setText("ffffff00"));
            lineStyle.addContent(new Element("width").setText("1"));
            style.addContent(lineStyle);
            documentTag.addContent(style);
            for (Country c : countries) {
                ArrayList<Element> elements = elementFromCountry(c);
                documentTag.addContent(elements);
            }
            kml.addContent(documentTag);
            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(document, new FileWriter(dest));

            System.out.println("XML File was created successfully!");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Element> elementFromCountry(Country country) {
        ArrayList<Element> elements = new ArrayList<>();
        ArrayList<ArrayList<Coordinate>> coordinateSet = country.getCoordinates();

        for (int i = 0; i < coordinateSet.size(); i++) {
            Element placemark = new Element("Placemark");
            placemark.addContent(new Element("name").setText(country.getName()));
            placemark.addContent(new Element("styleUrl").setText("#orange-5px"));

            Element lineString = new Element("LineString");
            lineString.addContent(new Element("tessellate").setText("1"));
            String coordinatesStr = "";
            for (int j = 0; j < coordinateSet.get(i).size(); j++) {
                Coordinate c = coordinateSet.get(i).get(j);
                coordinatesStr = coordinatesStr.concat(c.toString() + " ");
            }
            Element coordinates = new Element("coordinates");
            coordinates.setText(coordinatesStr);
            lineString.addContent(coordinates);
            placemark.addContent(lineString);
            elements.add(placemark);
        }

        return elements;
    }
}
