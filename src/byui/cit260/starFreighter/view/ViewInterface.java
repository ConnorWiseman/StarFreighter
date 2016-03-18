package byui.cit260.starFreighter.view;

/**
 * A basic view interface.
 * @author Connor
 */
interface ViewInterface {
    public void display();
    public char getInput();
    public boolean doAction(char action);
}