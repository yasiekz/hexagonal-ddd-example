package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

public class CannotCreatePatientException extends RuntimeException {

    private static final long serialVersionUID = -4435412014345095197L;

    public CannotCreatePatientException(final String message) {
        super(message);
    }
}
