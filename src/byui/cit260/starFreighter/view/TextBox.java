package byui.cit260.starFreighter.view;

import java.util.ArrayList;

/**
 * A convenient formatter for printing text inside a box.
 * @author Connor
 */
public final class TextBox extends DisplayFormat {
    /**
     * Sets necessary properties for proper display.
     */
    private TextBox() {
    }
    
    /**
     * Displays a specific string in a box. 
     * @param multiple
     */
    public static void displayText(String... multiple) {
        // Display the top separator and spacing.
        displaySeparator();
        displaySeparatorSpacing();
        
        // Iterate over each String supplied as an argument.
        for (String text : multiple) {
            if (text.length() < MAX_WIDTH) {
                // If it's a short string, just display it as a line.
                displayLine(text);
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
                lines.stream().forEach((line) -> {
                    displayLine(line);
                });
            }
            // Display spacing after each block of text.
            displaySeparatorSpacing();
        }
        // Display the bottom separator.
        displaySeparator();
    }
}