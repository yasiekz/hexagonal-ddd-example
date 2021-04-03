package io.yasiekz.github.hexagonaldddexample.domain;

import io.yasiekz.github.hexagonaldddexample.domain.event.Event;
import java.util.*;
import org.springframework.util.Assert;

public abstract class AggregateRoot {

    private final transient List<Event> domainEvents = new ArrayList<>();

    public abstract UUID getId();

    protected <T extends Event> void registerEvent(T event) {
        Assert.notNull(event, "Domain event must not be null!");
        this.domainEvents.add(event);
    }

    protected Collection<? extends Event> getDomainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }
}
