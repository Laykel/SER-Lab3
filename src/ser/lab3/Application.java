package ser.lab3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Main entry point for our GeoJSON parser
 */
public class Application {
    private final static String INPUT_FILE = "data/countries.geojson";
    private static final String xmlFilePath = "data/result.kml";

    private static ArrayList<Country> countries = new ArrayList<>();

    public static void main(String[] args) {
        GeoJSONParser parser = new GeoJSONParser(INPUT_FILE);

        parser.parse();

        countries = parser.getCountries();

        kmlBuilder.buildKml(countries,xmlFilePath);
    }
}