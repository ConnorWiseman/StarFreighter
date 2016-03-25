package byui.cit260.starFreighter.view;

import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 * A simple error logging class.
 */
public class ErrorView {
    /**
     * Class constants.
     */
    private static final PrintWriter errorFile = StarFreighter.getOutFile();
    private static final PrintWriter logFile = StarFreighter.getLogFile();
    
    /**
     * Displays the error, then logs it to a file.
     * @param className
     * @param errorMessage 
     */
    public static void display(String className, String errorMessage) {
        errorFile.println("--------------------------------");
        errorFile.println("- ERROR - " + errorMessage);
        errorFile.println("--------------------------------");
        logFile.println(className + " - " + errorMessage);
    }
}