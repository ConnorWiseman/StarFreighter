package byui.cit260.starFreighter.constants;

/**
 * The items in the game.
 */
public enum ItemList {
    JUNK("Junk", 5, 1),
    OLD_PARTS("Old Parts", 20, 1),
    NEW_PARTS("New Parts", 50, 1),
    BIO_SEDIMENTS("Bio Sediments", 30, 1),
    PEARL("Pearl", 75, 1);
    
    /**
     * Constants.
     */
    private final String name;
    private final int value;
    private final int quantity;
    
    /**
     * Constructor.
     * @param name
     * @param value 
     */
    ItemList(String name, int value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }
    
    /**
     * Gets the item's name.
     * @return 
     */
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Gets the item's value.
     * @return 
     */
    public int getValue() {
        return value;
    }
}