package io.darbata.journal.advice;

import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.exceptions.EntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntryAdvice {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<String> handleEntryNotFound(EntryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
