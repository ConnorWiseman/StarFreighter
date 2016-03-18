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
     * Sets necessary properties for proper display.
     */
    public MenuView() {
    }

    /**
     * Displays the menu.
     */
    protected void displayMenu() {
        displaySeparator(MAX_WIDTH, H_SYMBOL);
        displayLine(menuTitle, MAX_WIDTH, V_SYMBOL);
        displaySeparator(MAX_WIDTH, H_SYMBOL);
        menuItems.stream().forEach((item) -> {
            displayLine(
                item.symbol() + DIVIDER + item.name(),
                MAX_WIDTH,
                V_SYMBOL
            );
        });
        displaySeparator(MAX_WIDTH, H_SYMBOL);
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