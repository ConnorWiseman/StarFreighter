package byui.cit260.starFreighter.view;

import java.util.Scanner;

/**
 * Convenient methods for retrieving various types of user input.
 */
public final class Input {

    /**
     * Class constants.
     */
    private final static Scanner KEYBOARD_INPUT = new Scanner(System.in);

    /**
     * Private constructor prevents instantiation.
     */
    private Input() {
        
    }

    /**
     * Gets a character, accepting input on the next line.
     * @param prompt
     * @return 
     */
    public static char getChar(String prompt) {
        return promptForCharacter(prompt, false);
    }

    /**
     * Gets a character, accepting input on the same line.
     * @param prompt
     * @return 
     */
    public static char getCharSameLine(String prompt) {
        return promptForCharacter(prompt, true);
    }

    /**
     * Gets an uppercase character, accepting input on the next line.
     * @param prompt
     * @return 
     */
    public static char getCharUppercase(String prompt) {
        return Character.toUpperCase(getChar(prompt));
    }

    /**
     * Gets an uppercase character, accepting input on the same line.
     * @param prompt
     * @return 
     */
    public static char getCharSameLineUppercase(String prompt) {
        return Character.toUpperCase(getCharSameLine(prompt));
    }

    /**
     * Displays a prompt, then gets a string of user input.
     * @param prompt
     * @param sameLine
     * @return
     */
    private static char promptForCharacter(String prompt, boolean sameLine) {
        char characterValue;

        while(true) {
            if (sameLine) {
                System.out.print(prompt);
            }
            else {
                System.out.println(prompt);
            }

            String value = KEYBOARD_INPUT.nextLine().trim();
            
            if (value.length() < 1) {
                System.out.println("Invalid input - please enter something.");
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
     */
    public static String getString(String prompt) {
        return promptForString(prompt, false);
    }

    /**
     * Gets a string, accepting input on the same line.
     * @param prompt
     * @return 
     */
    public static String getStringSameLine(String prompt) {
        return promptForString(prompt, true);
    }

    /**
     * Displays a prompt, then gets a string of user input.
     * @param prompt
     * @param sameLine
     * @return
     */
    private static String promptForString(String prompt, boolean sameLine) {
        String value = null;

        while(true) {
            if (sameLine) {
                System.out.print(prompt);
            }
            else {
                System.out.println(prompt);
            }

            value = KEYBOARD_INPUT.nextLine().trim();
            
            if (value.length() < 1) {
                System.out.println("Invalid input - please enter something.");
                continue;
            }
            // Once we have valid input, break from the loop.
            break;
        }
        
        // Return the user's input.
        return value;
    }
}