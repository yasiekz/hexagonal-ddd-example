package io.yasiekz.github.hexagonaldddexample.application.dto.patient;

public class PatientNotFound extends RuntimeException {

    private static final long serialVersionUID = -4830218919738526623L;

    public PatientNotFound(final String message) {
        super(message);
    }
}
