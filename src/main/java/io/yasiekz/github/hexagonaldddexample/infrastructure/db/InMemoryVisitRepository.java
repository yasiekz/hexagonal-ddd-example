package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class InMemoryVisitRepository extends ImMemoryRepository<Visit> {

    public Stream<Visit> findByDoctorIdInFuture(final UUID doctorId) {

        return getAll().stream()
            .filter(v -> v.getCreatedAt().isAfter(LocalDateTime.now()))
            .filter(v -> v.getDoctor().getId().equals(doctorId));
    }

    public Stream<Visit> findByPatientIdInFuture(final UUID patientId) {

        return getAll().stream()
            .filter(v -> v.getCreatedAt().isAfter(LocalDateTime.now()))
            .filter(v -> v.getPatient().getId().equals(patientId));
    }
}
