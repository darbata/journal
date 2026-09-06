package io.darbata.journal.advice;

import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.exceptions.EntryNotFoundException;
import io.darbata.journal.exceptions.UnauthorisedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntryAdvice {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<?> handleEntryNotFound(EntryNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UnauthorisedAccessException.class)
    public ResponseEntity<?> handleUnauthorisedAccess(UnauthorisedAccessException ex) {
        return ResponseEntity.notFound().build();
    }

}
