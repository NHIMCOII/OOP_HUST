package CustomException;

public class InvaidInputException extends Exception {
    public InvaidInputException() {
        super("PLayer name cant be null.");
    }
}
