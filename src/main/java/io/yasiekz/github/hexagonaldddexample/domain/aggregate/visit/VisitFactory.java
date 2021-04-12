package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorPort;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.PatientPort;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VisitFactory {

    private static final String EXCEPTION_MESSAGE = "%s with ID=%s doesn't have free slot=%s at %s";

    private final DoctorPort doctorPort;
    private final PatientPort patientPort;

    public Visit create(final UUID id, final UUID patientId, final UUID doctorId, VisitSlot visitSlot, final
    LocalDate appointmentDate) {

        final Doctor doctor = doctorPort.get(doctorId);
        final Patient patient = patientPort.get(patientId);
        final LocalDate now = LocalDate.now();

        if (now.minusDays(14).isAfter(appointmentDate)) {
            throw new CannotCreateVisitException("Visit with date more than 14 days ahead cannot be created");
        }

        if (now.isBefore(appointmentDate)) {
            throw new CannotCreateVisitException("Cannot create visit with date from past");
        }

        if (!doctor.isSlotFree(visitSlot, appointmentDate)) {
            throw new CannotCreateVisitException(String.format(
                EXCEPTION_MESSAGE,
                "Doctor",
                doctorId,
                visitSlot,
                appointmentDate
            ));
        }

        if (!patient.isSlotFree(visitSlot, appointmentDate)) {
            throw new CannotCreateVisitException(String.format(
                EXCEPTION_MESSAGE,
                "Doctor",
                patientId,
                visitSlot,
                appointmentDate
            ));
        }

        return Visit.builder()
            .withId(id)
            .withVisitSlot(visitSlot)
            .withAppointmentDate(appointmentDate)
            .withCreatedAt(LocalDateTime.now())
            .withDoctor(doctor)
            .withPatient(patient)
            .build();
    }
}
