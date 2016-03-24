package byui.cit260.starFreighter.model;

import java.io.Serializable;

/**
 * Represents a planet.
 */
public enum Planet implements Serializable {
    /* The size of the map is defined in GameMap on a per-instance basis. If you
    receive an array out of bounds error, it's because one of the planets
    defined below falls outside the bounds of the map size.
    
    With the current setup, coordinates must also be positive. Sorry!
    Still working on figuring out that four-quadrant plane.
     */
    Kryta("A barren desert planet with a few secrets", 1, 1, 'K'),
    Qualufe("Oceans as far as the eye can see", 3, 4, 'Q'),
    Mezopan("Green forests and tall trees", 5, 4, 'M'),
    Redecent("Galaxy capital", 7, 8, 'R');

    private final String description;
    private final Point coords;
    private final char symbol;

    Planet(String description, int x, int y, char symbol) {
        this.description = description;
        this.coords = new Point(x, y);
        this.symbol = symbol;
    }
    
    public String description() {
        return description;
    }
    
    public Point coords() {
        return coords;
    }
    
    public char getSymbol() {
        return symbol;
    }

    public static Planet at(Point coords) {
        for (Planet planet : values()) {
            /* Comparing objects was being wonky here- comparing values instead,
               for now. */
            if (planet.coords() == coords) {
                System.out.println("hey");
            }
            if (planet.coords().x() == coords.x() &&
                planet.coords().x() == coords.x()) {
                return planet;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Planet{" + "name= " + name() + ", description= " + description + '}';
    }
}