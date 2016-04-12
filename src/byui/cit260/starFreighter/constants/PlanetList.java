package byui.cit260.starFreighter.constants;

import byui.cit260.starFreighter.control.RandomNumbers;
import byui.cit260.starFreighter.model.Point;

/**
 * A basic list of all the planets in the game.
 */
public enum PlanetList {
    KRYTA("Kryta",
            "A barren desert planet with a few secrets",
            'K',
            new Point(1, RandomNumbers.range(2, 8))),
    QUALUFE("Qualufe",
            "Oceans as far as the eye can see",
            'Q',
            new Point(RandomNumbers.range(5, 6), RandomNumbers.range(0, 9))),
    MEZOPAN("Mezopan",
            "Green forests and tall trees",
            'M',
            new Point(RandomNumbers.range(8, 10), RandomNumbers.range(2, 8))),
    REDECENT("Redecent",
            "The galaxy's capital",
            'R',
            new Point(RandomNumbers.range(13, 15), RandomNumbers.range(3, 7))),
    GOAL("Endgame",
            "Riches beyond imagining!",
            'E',
            new Point(RandomNumbers.range(23, 26), RandomNumbers.range(4, 6)));
    
    /**
     * Constants.
     */
    private final String name;
    private final String description;
    private final char symbol;
    private final Point coords;
    
    /**
     * Constructor.
     * @param name
     * @param description
     * @param symbol
     * @param coords 
     */
    PlanetList(String name, String description, char symbol, Point coords) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.coords = coords;
    }
    
    /**
     * Gets the planet's name.
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the planet's description.
     * @return 
     */
    public String getDesc() {
        return this.description;
    }
    
    /**
     * Gets the planet's symbol.
     * @return 
     */
    public char getSymbol() {
        return this.symbol;
    }
    
    /**
     * Gets the planet's coordinates.
     * @return 
     */
    public Point getCoords() {
        return this.coords;
    }
}