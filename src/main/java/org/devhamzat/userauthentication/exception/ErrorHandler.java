package org.devhamzat.userauthentication.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Value("")
    private String details;

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ApplicationError> handleUserNotFound(UserNotFound exception) {
        ApplicationError error = new ApplicationError();
        error.setCode(404);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(NullInput.class)
    public ResponseEntity<ApplicationError> handleNullInput(NullInput exception) {
        ApplicationError error = new ApplicationError();
        error.setCode(400);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
