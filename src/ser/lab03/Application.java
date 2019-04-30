package ser.lab03;// sources : https://howtodoinjava.com/json/json-simple-read-write-json-examples/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class Application {

    public static void main(String[] args) {
        
        //JSON parser object pour lire le fichier
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("src/countries.geojson")) {
            
            // lecture du fichier
            Object obj = jsonParser.parse(reader);
 
            JSONArray personne = (JSONArray) obj;
            System.out.println(personne);
             
            // parcours du tableau de personnes
            personne.forEach(pers->parseCountryObject((JSONObject)pers));
 
        }
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseCountryObject(JSONObject country) {
        
        // Obtenir l'objet personne dans la liste
        JSONObject countryObject = (JSONObject) country.get("feature");
         
        // obtenir les détails ...
        String nom    =  countryObject.get("properties").toString();


        // afficher le contenu
        System.out.println(nom);
      
    }
}