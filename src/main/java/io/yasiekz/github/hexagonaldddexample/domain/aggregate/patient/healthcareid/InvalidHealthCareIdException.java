package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

public class InvalidHealthCareIdException extends RuntimeException {

    private static final long serialVersionUID = 7700831626445619673L;

    public InvalidHealthCareIdException(final String message) {
        super(message);
    }
}
