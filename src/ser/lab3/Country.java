package ser.lab3;

import java.util.LinkedList;

/**
 * Country class to represent the content of the geojson file
 */
public class Country {
    private String name;
    private String abbreviation;
    // List of coordinates
    private LinkedList<LinkedList<Coordinate>> coordinates = new LinkedList<>();

    /**
     * Simple constructor
     */
    public Country() {
        coordinates.add(new LinkedList<>());
    }

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
     * @param coordinate The coordinate to add to the list
     */
    public void addCoordinate(Coordinate coordinate) {
        coordinates.get(0).add(coordinate);
    }

    /**
     * toString override to display country
     *
     * @return A string representation of the country
     */
    @Override
    public String toString() {
        return "(" + abbreviation + ") " + name + "\n" +
               "     - " + coordinates.get(0).size() + " coordinates";
    }
}
