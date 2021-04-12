package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Appointment;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitSlot;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class DoctorAppointment extends Appointment {

    UUID patientId;

    @Builder(setterPrefix = "with")
    public DoctorAppointment(final VisitSlot visitSlot,
        final LocalDate date, final UUID patientId) {
        super(visitSlot, date);
        this.patientId = patientId;
    }
}
