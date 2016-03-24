package byui.cit260.starFreighter.view;

import java.util.ArrayList;

/**
 * A convenient formatter for printing text inside a box.
 */
public final class TextBox {
    /**
     * Class constants.
     */
    private static final int MAX_WIDTH = 60;
    private static final String H_SYMBOL = "*";
    private static final String V_SYMBOL = "*";

    /**
     * Private constructor prevents instantiation.
     */
    private TextBox() {
    }
    
    /**
     * Displays a specific string in a box. 
     * @param multiple
     */
    public static void displayText(String... multiple) {
        // Display the top separator and spacing.
        DisplayFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
        DisplayFormat.displaySeparatorSpacing(MAX_WIDTH, V_SYMBOL);
        
        // Iterate over each String supplied as an argument.
        for (String text : multiple) {
            if (text.length() < MAX_WIDTH) {
                // If it's a short string, just display it as a line.
                DisplayFormat.displayLine(text, MAX_WIDTH, V_SYMBOL);
            }
            else {
                // If it's a long string, break it apart into words.
                String[] words = text.split(" ");
                
                // Prepare a temporary holder for preformatted lines.
                String tempLine = "";

                // Set up an ArrayList to hold our formatted lines.
                ArrayList<String> lines = new ArrayList<>();

                /* Iterate over each word and add it to the temporary line
                   until we hit the maximum width. */
                for (String word : words) {
                    if (tempLine.length() + word.length() < (MAX_WIDTH - 1)) {
                        tempLine += word + ' ';
                    }
                    else {
                        // Add the line to our ArrayList.
                        lines.add(tempLine);
                        // Do NOT forget to add the final word to the next line.
                        tempLine = word + ' ';
                    }
                }
                // Do NOT forget to add the final line to our ArrayList.
                lines.add(tempLine);
                
                // Display each line in the block of text.
                lines.stream().forEach((String line) -> {
                    DisplayFormat.displayLine(line, MAX_WIDTH, V_SYMBOL);
                });
            }
            // Display spacing after each block of text.
            DisplayFormat.displaySeparatorSpacing(MAX_WIDTH, V_SYMBOL);
        }
        // Display the bottom separator.
        DisplayFormat.displaySeparator(MAX_WIDTH, H_SYMBOL);
    }
}