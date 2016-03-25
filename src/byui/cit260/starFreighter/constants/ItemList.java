package byui.cit260.starFreighter.constants;

/**
 * The items in the game.
 */
public enum ItemList {
    JUNK("Junk", 5),
    OLD_PARTS("Old Parts", 20),
    NEW_PARTS("New Parts", 50);
    
    /**
     * Constants.
     */
    private final String name;
    private final int value;
    
    /**
     * Constructor.
     * @param name
     * @param value 
     */
    ItemList(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Gets the item's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the item's value.
     * @return 
     */
    public int getValue() {
        return value;
    }
}