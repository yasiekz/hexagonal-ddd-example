package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

public class DoctorNotFound extends RuntimeException {

    private static final long serialVersionUID = -4830218919738526623L;

    public DoctorNotFound(final String message) {
        super(message);
    }
}
