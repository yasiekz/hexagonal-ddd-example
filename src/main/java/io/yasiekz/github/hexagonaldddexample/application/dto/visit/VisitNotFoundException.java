package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

public class VisitNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3560268226743814322L;

    public VisitNotFoundException(final String message) {
        super(message);
    }
}
