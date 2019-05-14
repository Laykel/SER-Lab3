// sources : https://howtodoinjava.com/json/json-simple-read-write-json-examples/
package ser.lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {
    private final static String INPUT_FILE = "data/countries.geojson";

    private LinkedList<Country> countries = new LinkedList<>();

    public static void main(String[] args) {
        // JSON parser object to read our file
        JSONParser jsonParser = new JSONParser();

        // Open file
        try (FileReader reader = new FileReader(INPUT_FILE)) {
            // Parse file as JSON
            Object obj = jsonParser.parse(reader);

            // Get list of feature in the main FeatureCollection
            JSONArray features = (JSONArray) ((JSONObject) obj).get("features");

            // Parcours du tableau de personnes
            features.forEach(feature -> parseCountryObject((JSONObject) feature));
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseCountryObject(JSONObject feature) {
        Country country = new Country();

        country.setName((String) ((JSONObject) feature.get("properties")).get("ADMIN"));

        country.setAbbreviation((String) ((JSONObject) feature.get("properties")).get("ISO_A3"));

        System.out.println(country);
    }
}