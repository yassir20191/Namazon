package Account.Exceptions;

public class UserDoesNotExistException extends Exception{
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
