package CustomException;

public class InvalidPlayerNameException extends Exception {
    public InvalidPlayerNameException() {
        super("PLayer name cant be null.");
    }
}
