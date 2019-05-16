package ser.lab3;

import java.util.LinkedList;

/**
 * Main entry point for our GeoJSON parser
 */
public class Application {
    private final static String INPUT_FILE = "data/countries.geojson";

    private static LinkedList<Country> countries = new LinkedList<>();

    public static void main(String[] args) {
        GeoJSONParser parser = new GeoJSONParser(INPUT_FILE);

        parser.parse();

        countries = parser.getCountries();
    }
}