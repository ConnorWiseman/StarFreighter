package byui.cit260.starFreighter.view;

/**
 * A utility class for displaying text boxes, menus, and the like in a uniform
 * format.
 * @author Connor
 */
public abstract class DisplayFormat {
    protected static int MAX_WIDTH = 60;
    protected static String H_SYMBOL = "*";
    protected static String V_SYMBOL = "*";
    protected static String DIVIDER;

    /**
     * Creates a string of a specified length, then fills it with a specified
     * substring.
     * @param length
     * @param fill
     * @return 
     */
    protected static String fillString(int length, String fill) {
        String constructed = new String(new char[length]);
        return constructed.replace("\0", fill);
    }

    /**
     * Utility function. Displays a horizontal separator.
     */
    protected static void displaySeparator() {
        System.out.println(fillString(MAX_WIDTH + 3, H_SYMBOL));
    }

    /**
     * Utility function. Displays horizontal separator spacing.
     */
    protected static void displaySeparatorSpacing() {
        String repeated = fillString(MAX_WIDTH + 1, " ");
        System.out.println(V_SYMBOL + repeated + V_SYMBOL);
    }

    /**
     * Utility function. Formats and displays a single line of text.
     * @param line 
     */
    protected static void displayLine(String line) {
        String finalLine = V_SYMBOL + " " + line;
        int lengthDifference = MAX_WIDTH - line.length();
        String emptySpace = fillString(lengthDifference, " ");
        finalLine += emptySpace + V_SYMBOL;
        System.out.println(finalLine);
    }
}
