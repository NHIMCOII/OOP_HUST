package CustomException;

public class EnoughPlayerException extends Exception {
    public EnoughPlayerException() {
        super("Enough number of players, 4 player created");
    }
}
