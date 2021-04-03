package io.yasiekz.github.hexagonaldddexample.infrastructure.db.query;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.DoctorNotFound;
import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.DoctorProjection;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.application.query.DoctorQuery;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryDoctorRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InMemoryDoctorQuery implements DoctorQuery {

    private final InMemoryDoctorRepository db;

    public List<DoctorProjection> getAll() {

        return db.getAll().stream().map(this::get).collect(Collectors.toList());
    }

    @Override
    public DoctorProjection get(final UUID id) {
        return db.get(id)
            .map(this::get)
            .orElseThrow(() -> new DoctorNotFound(String.format("Doctor with ID=%s not found", id)));
    }

    private DoctorProjection get(final Doctor doctor) {

        return DoctorProjection.builder()
            .withId(doctor.getId())
            .withName("Janusz lecznictwa")
            .withSpecialization(DoctorSpecialization.PROCTOLOGIST)
            .build();

    }
}
