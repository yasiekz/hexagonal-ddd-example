package io.yasiekz.github.hexagonaldddexample.domain.event;

public interface EventPublisher {

    void publish(Event event);

}
