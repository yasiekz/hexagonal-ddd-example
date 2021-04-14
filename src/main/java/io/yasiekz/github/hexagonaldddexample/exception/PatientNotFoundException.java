package io.yasiekz.github.hexagonaldddexample.exception;

public class PatientNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -614858322881027447L;

    public PatientNotFoundException(final String message) {
        super(message);
    }
}
