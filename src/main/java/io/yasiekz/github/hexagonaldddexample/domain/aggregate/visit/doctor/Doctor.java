package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitPart;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Doctor extends VisitPart<DoctorAppointment> {

    UUID id;

    @Builder(setterPrefix = "with")
    public Doctor(
        final List<DoctorAppointment> appointments, final UUID id) {
        super(appointments);
        this.id = id;
    }
}
