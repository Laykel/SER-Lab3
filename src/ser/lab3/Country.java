package ser.lab3;

import java.util.ArrayList;

public class Country {
    private String name;
    private String abbreviation;
    private ArrayList<ArrayList<Coordinate>> coordinates;

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "(" + abbreviation + ") " + name + "\n" +
               "     - " + coordinates.get(0).size() + " coordinates";
    }

    public String getName() {
        return name;
    }

    public ArrayList<ArrayList<Coordinate>> getCoordinates() {
        return coordinates;
    }
}
