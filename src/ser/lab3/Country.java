/**
 * SER - Laboratoire 3 : Parsing Geojson to KML
 * Fichier : Country.java
 * Auteurs : Marion Dutu Launay, Luca-Manu Reis De Carvalho, Luc Wachter
 * Date : 19 mai 2019
 */

package ser.lab3;

import java.util.ArrayList;

/**
 * Country class to represent the content of the geojson file
 */
public class Country {
    private String name;
    private String abbreviation;

    // List of coordinates
    private ArrayList<ArrayList<Coordinate>> coordinates = new ArrayList<>();

    /**
     * Simple setter for the name of the country
     *
     * @param name The name of the country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Simple setter for the country's abbreviation
     *
     * @param abbreviation The country name's abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Add a coordinate to the list
     *
     * @param level      Which list of coordinates
     * @param coordinate The coordinate to add to the list
     */
    public void addCoordinate(int level, Coordinate coordinate) {
        if (coordinates.size() < level + 1) {
            coordinates.add(new ArrayList<>());
        }

        coordinates.get(level).add(coordinate);
    }

    /**
     * toString override to display country
     *
     * @return A string representation of the country
     */
    @Override
    public String toString() {
        StringBuilder ret;
        ret = new StringBuilder("(" + abbreviation + ") " + name);

        for (ArrayList<Coordinate> coordList : coordinates) {
            ret.append("\n     - ").append(coordList.size()).append(" coordinates");
        }

        return ret.toString();
    }

    public String getName() {
        return name;
    }

    public ArrayList<ArrayList<Coordinate>> getCoordinates() {
        return coordinates;
    }
}
