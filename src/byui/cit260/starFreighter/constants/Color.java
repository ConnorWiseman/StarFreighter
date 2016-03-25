package byui.cit260.starFreighter.constants;

/**
 * A collection of ANSI color codes.
 */
public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32;1;2m"),
    YELLOW("\u001B[33;1;2m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35;1m"),
    CYAN("\u001B[36m");

    private final String color;
    
    Color(String color) {
        this.color = color;
    }
    
    public String get() {
        return color;
    }
}