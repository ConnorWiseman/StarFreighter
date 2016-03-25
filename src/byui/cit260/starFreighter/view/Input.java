package byui.cit260.starFreighter.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 * Convenient methods for retrieving various types of user input.
 */
public final class Input {

    /**
     * Class constants.
     */
    private final static BufferedReader KEYBOARD_INPUT = StarFreighter.getInFile();
    private final static PrintWriter console = StarFreighter.getOutFile();

    /**
     * Private constructor prevents instantiation.
     */
    private Input() {
        
    }

    /**
     * Gets a character, accepting input on the next line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static char getChar(String prompt) throws IOException {
        return promptForCharacter(prompt, false);
    }

    /**
     * Gets a character, accepting input on the same line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static char getCharSameLine(String prompt) throws IOException {
        return promptForCharacter(prompt, true);
    }

    /**
     * Gets an uppercase character, accepting input on the next line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static char getCharUppercase(String prompt) throws IOException {
        return Character.toUpperCase(getChar(prompt));
    }

    /**
     * Gets an uppercase character, accepting input on the same line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static char getCharSameLineUppercase(String prompt) throws IOException {
        return Character.toUpperCase(getCharSameLine(prompt));
    }

    /**
     * Displays a prompt, then gets a string of user input.
     * @param prompt
     * @param sameLine
     * @return
     */
    private static char promptForCharacter(String prompt, boolean sameLine) throws IOException {
        char characterValue;

        while(true) {
            if (sameLine) {
                console.write(prompt);
                console.flush();
            }
            else {
                console.println(prompt);
            }

            String value = KEYBOARD_INPUT.readLine().trim();
            
            if (value.length() < 1) {
                console.println("Invalid input - please enter something.");
                continue;
            }

            characterValue = value.charAt(0);
            // Once we have valid input, break from the loop.
            break;
        }       
        
        // Return the user's input.
        return characterValue;
    }

    /**
     * Gets a string, accepting input on the next line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static String getString(String prompt) throws IOException {
        return promptForString(prompt, false);
    }

    /**
     * Gets a string, accepting input on the same line.
     * @param prompt
     * @return 
     * @throws java.io.IOException 
     */
    public static String getStringSameLine(String prompt) throws IOException {
        return promptForString(prompt, true);
    }

    /**
     * Displays a prompt, then gets a string of user input.
     * @param prompt
     * @param sameLine
     * @return
     */
    private static String promptForString(String prompt, boolean sameLine) throws IOException {
        String value = null;

        while(true) {
            if (sameLine) {
                console.write(prompt);
                console.flush();
            }
            else {
                console.println(prompt);
            }

            value = KEYBOARD_INPUT.readLine().trim();
            
            if (value.length() < 1) {
                console.println("Invalid input - please enter something.");
                continue;
            }
            // Once we have valid input, break from the loop.
            break;
        }
        
        // Return the user's input.
        return value;
    }
}