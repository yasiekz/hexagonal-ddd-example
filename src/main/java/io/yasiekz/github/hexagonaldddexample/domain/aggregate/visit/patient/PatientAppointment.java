package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Appointment;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitSlot;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class PatientAppointment extends Appointment {

    UUID doctorId;

    @Builder(setterPrefix = "with")
    public PatientAppointment(final VisitSlot visitSlot,
        final LocalDate date, final UUID doctorId) {
        super(visitSlot, date);
        this.doctorId = doctorId;
    }
}
