package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

public class CannotCreateVisitException extends RuntimeException {

    private static final long serialVersionUID = 6206420326415458719L;

    public CannotCreateVisitException(final String message) {
        super(message);
    }
}
