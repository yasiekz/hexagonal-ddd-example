package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.Repository;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.event.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PatientRepository extends DomainRepository<Patient> {

    public PatientRepository(
        final Repository<Patient> repository,
        final EventPublisher eventPublisher) {
        super(repository, eventPublisher);
    }
}
