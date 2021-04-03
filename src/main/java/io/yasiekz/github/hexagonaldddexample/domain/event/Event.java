package io.yasiekz.github.hexagonaldddexample.domain.event;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public abstract class Event {

    private final UUID id;

    public Event() {
        this.id = UUID.randomUUID();
    }
}
