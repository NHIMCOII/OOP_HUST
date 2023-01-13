package CustomException;

public class EnoughDiceException extends Exception {
    public EnoughDiceException() {
        super("Enough number of dices, 4 dices created");
    }

}
