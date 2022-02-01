package edu.epam.pet.exception.converter;

import lombok.Getter;

@Getter
public class IllegalEnumArgumentException extends ConverterException {

    private String incorrectValue;

    public IllegalEnumArgumentException() {
        super();
    }

    public IllegalEnumArgumentException(String message, String incorrectValue) {
        super(message);
        this.incorrectValue = incorrectValue;
    }

    public IllegalEnumArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalEnumArgumentException(Throwable cause) {
        super(cause);
    }
}
