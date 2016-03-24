package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;
import java.util.ArrayList;

/**
 * An abstraction layer between other menu classes and the view interface.
 */
public abstract class MenuView implements ViewInterface {
    /**
     * Class constants.
     */
    private static final int MAX_WIDTH = 32;
    private static final String H_SYMBOL = "-";
    private static final String V_SYMBOL = "|";
    private static final String DIVIDER = " - ";
    protected static String INVALID = "\nInvalid selection. Please try again.";

    /**
     * Class instance properties.
     */
    protected String menuTitle;
    protected final ArrayList<MenuItem> menuItems = new ArrayList<>();

    /**
     * Public constructor.
     */
    public MenuView() {
    }

    /**
     * Displays the menu.
     */
    protected void displayMenu() {
        DisplayFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
        DisplayFormat.displayLine(menuTitle, MAX_WIDTH, V_SYMBOL);
        DisplayFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
        menuItems.stream().forEach((item) -> {
            DisplayFormat.displayLine(
                item.symbol() + DIVIDER + item.name(),
                MAX_WIDTH,
                V_SYMBOL
            );
        });
        DisplayFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
    }
    
    /**
     * Gets the menu's title.
     * @return 
     */
    protected String getTitle() {
        return menuTitle;
    }

    @Override
    public char getInput() {
        return Input.getCharSameLineUppercase("Select an option: ");
    }

    @Override
    public void display() {
        char value;
        boolean done = false;

        /* Display the menu, prompt for input, and perform an action.
           Loop until the user decides to exit. */
        do {
            displayMenu();
            value = getInput();
            done = doAction(value);
        } while (!done);
    }
}