package io.yasiekz.github.hexagonaldddexample.application.handler.patient;

import io.yasiekz.github.hexagonaldddexample.application.dto.patient.CreatePatientRequest;
import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.PatientFactory;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreatePatientHandler {

    private final PatientFactory patientFactory;
    private final DomainRepository<Patient> repository;

    public void create(UUID id, CreatePatientRequest request) {

        final Patient patient = patientFactory.create(
            id,
            request.getName(),
            request.getIdNumber(),
            request.getPhoneNumber()
        );

        repository.save(patient);

        // here we can publish application events, which is handled by application layer
        // for example to update projections in read model if we want to
    }
}
