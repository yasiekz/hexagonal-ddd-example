package io.yasiekz.github.hexagonaldddexample.infrastructure.db.query;

import io.yasiekz.github.hexagonaldddexample.application.dto.visit.Doctor;
import io.yasiekz.github.hexagonaldddexample.application.dto.visit.VisitNotFoundException;
import io.yasiekz.github.hexagonaldddexample.application.dto.visit.VisitProjection;
import io.yasiekz.github.hexagonaldddexample.application.dto.visit.VisitSlot;
import io.yasiekz.github.hexagonaldddexample.application.query.VisitQuery;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryPatientRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InMemoryVisitQuery implements VisitQuery {

    private final InMemoryPatientRepository db;

    public List<VisitProjection> getAll() {

        return db.getAll().stream().map(this::get).collect(Collectors.toList());
    }

    @Override
    public VisitProjection get(final UUID id) {
        return db.get(id)
            .map(this::get)
            .orElseThrow(() -> new VisitNotFoundException(String.format("Visit with ID=%s not found", id)));
    }

    private VisitProjection get(final Patient patient) {

        return VisitProjection.builder()
            .withId(patient.getId())
            .withDate(LocalDate.now())
            .withVisitSpace(VisitSlot.FIRST)
            .withDoctor(Doctor.builder().withId(UUID.randomUUID()).withName("Lekarz lekarzowy").build())
            .withPatient(io.yasiekz.github.hexagonaldddexample.application.dto.visit.Patient.builder()
                .withId(UUID.randomUUID())
                .build())
            .build();
    }
}
