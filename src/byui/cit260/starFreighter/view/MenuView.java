package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;
import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public abstract class MenuView extends DisplayFormat implements ViewInterface {
    /**
     * Class constants.
     */
    protected static int MAX_WIDTH = 32;
    protected static String H_SYMBOL = "-";
    protected static String V_SYMBOL = "|";
    protected static String DIVIDER = " - ";
    protected final String INVALID = "\nInvalid selection. Please try again.";

    /**
     * Class instance properties.
     */
    protected String menuTitle;
    protected final ArrayList<MenuItem> menuItems = new ArrayList<>();

    /**
     * Sets necessary properties for proper display.
     */
    public MenuView() {
    }

    /**
     * Displays the menu.
     */
    protected void displayMenu() {
        displaySeparator();
        displayLine(menuTitle);
        displaySeparator();
        menuItems.stream().forEach((item) -> {
            displayLine(item.symbol() + DIVIDER + item.name());
        });
        displaySeparator();
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