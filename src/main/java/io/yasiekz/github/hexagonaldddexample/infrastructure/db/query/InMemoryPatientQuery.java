package io.yasiekz.github.hexagonaldddexample.infrastructure.db.query;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.DoctorNotFound;
import io.yasiekz.github.hexagonaldddexample.application.dto.patient.PatientProjection;
import io.yasiekz.github.hexagonaldddexample.application.query.PatientQuery;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryPatientRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InMemoryPatientQuery implements PatientQuery {

    private final InMemoryPatientRepository db;

    public List<PatientProjection> getAll() {

        return db.getAll().stream().map(this::get).collect(Collectors.toList());
    }

    @Override
    public PatientProjection get(final UUID id) {
        return db.get(id)
            .map(this::get)
            .orElseThrow(() -> new DoctorNotFound(String.format("Doctor with ID=%s not found", id)));
    }

    private PatientProjection get(final Patient patient) {

        return PatientProjection.builder()
            .withId(patient.getId())
            .withName("Janusz lecznictwa")
            .withPesel("123123123")
            .build();

    }
}
