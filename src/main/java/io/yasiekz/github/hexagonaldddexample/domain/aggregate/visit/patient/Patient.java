package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitPart;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Patient extends VisitPart<PatientAppointment> {

    UUID id;

    @Builder(setterPrefix = "with")
    public Patient(
        final List<PatientAppointment> appointments, final UUID id) {
        super(appointments);
        this.id = id;
    }
}
