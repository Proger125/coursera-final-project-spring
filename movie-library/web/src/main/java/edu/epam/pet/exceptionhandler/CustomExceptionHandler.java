package edu.epam.pet.exceptionhandler;

import edu.epam.pet.exception.converter.IllegalEnumArgumentException;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleResourceNotFoundException(ResourceNotFoundException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setErrorCode(404);
        if (e.getId() != null) {
            exceptionMessage.setMessage("Resource not found, id: " + e.getId());
        } else {
            exceptionMessage.setMessage("Resource not found");
        }

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalEnumArgumentException.class)
    public ResponseEntity<ExceptionMessage> handleIllegalEnumArgumentException(IllegalEnumArgumentException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setErrorCode(400);
        exceptionMessage.setMessage("Illegal enum argument: " + e.getIncorrectValue() + ". It should be male or female");
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }
}
