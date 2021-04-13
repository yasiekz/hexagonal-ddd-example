package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.Repository;
import io.yasiekz.github.hexagonaldddexample.domain.event.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class VisitRepository extends DomainRepository<Visit> {

    public VisitRepository(
        final Repository<Visit> repository,
        final EventPublisher eventPublisher) {
        super(repository, eventPublisher);
    }
}
