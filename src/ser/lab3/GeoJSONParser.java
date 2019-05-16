/**
 * SER - Laboratoire 3 : Parsing Geojson to KML
 * Fichier : GeoJSONParser.java
 * Auteurs : Marion Dutu Launay, Luca-Manu Reis De Carvalho, Luc Wachter
 * Date : 19 mai 2019
 */

package ser.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Main parser class for our GeoJSON file
 * <p>
 * Sources: https://howtodoinjava.com/json/json-simple-read-write-json-examples/
 */
public class GeoJSONParser {
    private String inputFile;

    private ArrayList<Country> countries = new ArrayList<>();

    /**
     * Simple constructor
     *
     * @param inputFile The path to the file to parse
     */
    public GeoJSONParser(String inputFile) {
        this.inputFile = inputFile;
    }

    /**
     * Main parsing method for our GeoJSON file
     */
    public void parse() {
        // JSON parser object to read our file
        JSONParser jsonParser = new JSONParser();

        // Open file
        try (FileReader reader = new FileReader(inputFile)) {
            // Parse file as JSON
            Object obj = jsonParser.parse(reader);

            // Get list of feature in the main FeatureCollection
            JSONArray features = (JSONArray) ((JSONObject) obj).get("features");

            // Run through features and parse
            features.forEach(feature -> parseCountryObject((JSONObject) feature));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used on every feature in the GeoJSON file
     *
     * @param feature The feature we want to parse
     */
    private void parseCountryObject(JSONObject feature) {
        Country country = new Country();

        JSONObject properties = (JSONObject) feature.get("properties");

        // Set country's attributes
        country.setName((String) properties.get("ADMIN"));

        country.setAbbreviation((String) properties.get("ISO_A3"));

        JSONObject geometry = (JSONObject) feature.get("geometry");

        // Check whether the geometry we're working with is a Polygon or a MultiPolygon
        boolean multi = !geometry.get("type").equals("Polygon");

        // Get array of coordinates (or array of arrays of coordinates)
        JSONArray array = (JSONArray) geometry.get("coordinates");

        int counter = 0;

        // Iterate through coordinates (or through arrays of coordinates)
        for (Object maybeCoordinates : array) {

            // Iterate through coordinates (or through arrays of coordinates)
            for (Object maybeCoordinate : (JSONArray) maybeCoordinates) {
                // If we are working with a MultiPolygon
                if (multi) {
                    // Iterate through sub-array of coordinates
                    for (Object coordinate : (JSONArray) maybeCoordinate) {
                        // And record the coordinates in the country
                        JSONArray coord = (JSONArray) coordinate;
                        country.addCoordinate(counter, new Coordinate((double) coord.get(0), (double) coord.get(1)));
                    }

                    counter++;
                } else {
                    // Record the coordinates in the country
                    JSONArray coord = (JSONArray) maybeCoordinate;
                    country.addCoordinate(counter, new Coordinate((double) coord.get(0), (double) coord.get(1)));
                }
            }
        }

        // Add country to list
        countries.add(country);

        // Debug
        System.out.println(country);
    }

    /**
     * Simple getter for the list of parsed countries
     *
     * @return The list of parsed countries
     */
    public ArrayList<Country> getCountries() {
        return countries;
    }
}
