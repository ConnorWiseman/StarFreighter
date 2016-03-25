package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import starfreighter.StarFreighter;

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
    protected static final PrintWriter CONSOLE = StarFreighter.getOutFile();

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
        TextFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
        TextFormat.displayLine(menuTitle, MAX_WIDTH, V_SYMBOL);
        TextFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
        menuItems.stream().forEach((item) -> {
            TextFormat.displayLine(
                item.symbol() + DIVIDER + item.name(),
                MAX_WIDTH,
                V_SYMBOL
            );
        });
        TextFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
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
        char input = 0;
        try {
            input = Input.getCharSameLineUppercase("Select an option: ");
        } catch (IOException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
        return input;
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