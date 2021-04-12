package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.Patient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(setterPrefix = "with")
public class Visit extends AggregateRoot {

    UUID id;
    Doctor doctor;
    Patient patient;
    VisitSlot visitSlot;
    LocalDate appointmentDate;
    LocalDateTime createdAt;
}
