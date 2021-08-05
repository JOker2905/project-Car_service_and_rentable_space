package exceptions;

public class TooManyThingsException extends Exception{
    public TooManyThingsException(final String message) {
        super(message);
    }
}
