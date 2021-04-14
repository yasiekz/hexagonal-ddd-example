package io.yasiekz.github.hexagonaldddexample.exception;

public class CannotCreatePatientException extends RuntimeException {

    private static final long serialVersionUID = -7250176343290355054L;

    public CannotCreatePatientException(final String message) {
        super(message);
    }
}
