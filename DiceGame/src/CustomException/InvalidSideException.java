package CustomException;

public class InvalidSideException extends Exception {
    public InvalidSideException() {
        super("Side number must be between 1 - 6 and percentage of each must be 16% or 20%.");
    }
}
