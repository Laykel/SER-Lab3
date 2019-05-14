package ser.lab3;

import java.util.LinkedList;

public class Country {
    private String name;
    private String abbreviation;
    private LinkedList<LinkedList<Coordinate>> coordinates;

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
}
