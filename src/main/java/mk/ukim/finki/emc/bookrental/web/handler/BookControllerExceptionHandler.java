package mk.ukim.finki.emc.bookrental.web.handler;

import mk.ukim.finki.emc.bookrental.model.exception.NoAvailableCopiesException;
import mk.ukim.finki.emc.bookrental.model.exception.ResourceNotFoundException;
import mk.ukim.finki.emc.bookrental.web.controller.BookController;
import mk.ukim.finki.emc.bookrental.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(NoAvailableCopiesException.class)
    public ResponseEntity<ApiError> handleNoAvailableCopies(NoAvailableCopiesException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
