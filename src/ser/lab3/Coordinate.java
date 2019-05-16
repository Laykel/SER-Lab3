/**
 * SER - Laboratoire 3 : Parsing Geojson to KML
 * Fichier : Coordinate.java
 * Auteurs : Marion Dutu Launay, Luca-Manu Reis De Carvalho, Luc Wachter
 * Date : 19 mai 2019
 */

package ser.lab3;

/**
 * Class to represent a coordinate
 */
public class Coordinate {
    private double x;
    private double y;

    /**
     * Simple constructor
     *
     * @param x A double for the x component
     * @param y A double for the y component
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }



 	 /**
     *  toString
     *
     * @return A string representing the coordinate
     */
    @Override
    public String toString() {
        return x+"," +y;
    }
}
