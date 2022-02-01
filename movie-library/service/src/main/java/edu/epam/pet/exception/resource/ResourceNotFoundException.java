package edu.epam.pet.exception.resource;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private Long id;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
