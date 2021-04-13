package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.event.VisitCreated;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.Patient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class Visit extends AggregateRoot {

    UUID id;
    Doctor doctor;
    Patient patient;
    VisitSlot visitSlot;
    LocalDate appointmentDate;
    LocalDateTime createdAt;

    Visit(final UUID id, final Doctor doctor,
        final Patient patient, final VisitSlot visitSlot, final LocalDate appointmentDate,
        final LocalDateTime createdAt) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.visitSlot = visitSlot;
        this.appointmentDate = appointmentDate;
        this.createdAt = createdAt;

        registerEvent(new VisitCreated(id));
    }
}
