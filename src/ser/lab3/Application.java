/**
 * SER - Laboratoire 3 : Parsing Geojson to KML
 * Fichier : Application.java
 * Auteurs : Marion Dutu Launay, Luca-Manu Reis De Carvalho, Luc Wachter
 * Date : 19 mai 2019
 */

package ser.lab3;

import java.util.ArrayList;

/**
 * Main entry point for our GeoJSON parser
 */
public class Application {
    private final static String INPUT_FILE = "data/countries.geojson";
    private static final String xmlFilePath = "data/result.kml";

    public static void main(String[] args) {
        GeoJSONParser parser = new GeoJSONParser(INPUT_FILE);
        parser.parse();

        ArrayList<Country> countries = parser.getCountries();
        KMLBuilder.buildKml(countries, xmlFilePath);
    }
}