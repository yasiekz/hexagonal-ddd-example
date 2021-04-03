package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.Repository;
import io.yasiekz.github.hexagonaldddexample.domain.event.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DoctorRepository extends DomainRepository<Doctor> {

    public DoctorRepository(
        final Repository<Doctor> repository,
        final EventPublisher eventPublisher) {
        super(repository, eventPublisher);
    }
}
