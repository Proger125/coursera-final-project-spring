package edu.epam.pet.exception.resource;

public class TakenPlaceException extends RuntimeException{
    public TakenPlaceException() {
        super();
    }

    public TakenPlaceException(String message) {
        super(message);
    }

    public TakenPlaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TakenPlaceException(Throwable cause) {
        super(cause);
    }
}
