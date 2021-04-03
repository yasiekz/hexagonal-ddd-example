package io.yasiekz.github.hexagonaldddexample.domain;

import io.yasiekz.github.hexagonaldddexample.domain.event.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public abstract class DomainRepository<T extends AggregateRoot> {

    private final Repository<T> repository;
    private final EventPublisher eventPublisher;

    public final void save(final T aggregateRoot) {

        log.info("Saving aggregate root with ID={}", aggregateRoot.getId());
        repository.save(aggregateRoot);
        log.info("Aggregate with ID={} saved", aggregateRoot.getId());
        aggregateRoot.getDomainEvents().forEach(eventPublisher::publish);
    }
}
