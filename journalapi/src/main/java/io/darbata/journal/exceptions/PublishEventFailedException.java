package io.darbata.journal.exceptions;

public class PublishEventFailedException extends RuntimeException {
    public PublishEventFailedException(String message) {
        super(message);
    }
}
