// sources : https://howtodoinjava.com/json/json-simple-read-write-json-examples/
package ser.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {
    private final static String INPUT_FILE = "data/countries.geojson";

    private static LinkedList<Country> countries = new LinkedList<>();

    public static void main(String[] args) {
        // JSON parser object to read our file
        JSONParser jsonParser = new JSONParser();

        // Open file
        try (FileReader reader = new FileReader(INPUT_FILE)) {
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

    private static void parseCountryObject(JSONObject feature) {
        Country country = new Country();

        JSONObject properties = (JSONObject)  feature.get("properties");

        // Set country's attributes
        country.setName((String) properties.get("ADMIN"));

        country.setAbbreviation((String) properties.get("ISO_A3"));

        JSONArray array = (JSONArray) ((JSONObject) feature.get("geometry")).get("coordinates");

        array.forEach(coordinates -> {
            ((JSONArray) coordinates).forEach(coordinate -> {
                JSONArray coord = (JSONArray) coordinate;
                country.addCoordinate(new Coordinate((double) coord.get(0), (double) coord.get(1)));
            });
            System.out.println(country);
            System.exit(0);
        });

        // Add country to list
        countries.add(country);

        System.out.println(country);
    }
}