package byui.cit260.starFreighter.view;

import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 * A utility class for displaying text boxes, menus, and the like in a uniform
 * format.
 */
public class TextFormat {
    protected static PrintWriter console = StarFreighter.getOutFile();
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
     * @param maxWidth
     * @param hSymbol
     */
    protected static void displaySeparator(int maxWidth, String hSymbol) {
        console.println(fillString(maxWidth + 3, hSymbol));
    }

    /**
     * Utility function. Displays horizontal separator spacing.
     * @param maxWidth
     * @param vSymbol
     */
    protected static void displaySeparatorSpacing(int maxWidth, String vSymbol) {
        String repeated = fillString(maxWidth + 1, " ");
        console.println(vSymbol + repeated + vSymbol);
    }

    /**
     * Utility function. Formats and displays a single line of text.
     * @param line 
     * @param maxWidth 
     * @param vSymbol 
     */
    protected static void displayLine(String line, int maxWidth, String vSymbol) {
        String finalLine = vSymbol + " " + line;
        int lengthDifference = maxWidth - line.length();
        String emptySpace = fillString(lengthDifference, " ");
        finalLine += emptySpace + vSymbol;
        console.println(finalLine);
    }
}