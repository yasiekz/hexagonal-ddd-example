package io.yasiekz.github.hexagonaldddexample.infrastructure.db.visit;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorAppointment;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorPort;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.PatientAppointment;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.PatientPort;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryDoctorRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryPatientRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryVisitRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbPatientVisitAdapter implements PatientPort {

    private final InMemoryPatientRepository patientRepository;
    private final InMemoryVisitRepository visitRepository;

    @Override
    public Patient get(final UUID patientId) {

        final var patient = patientRepository.get(patientId)
            .orElseThrow(
                () -> new IllegalArgumentException(String.format("Could not fetch patient with ID=%s", patientId)));

        return Patient.builder()
            .withId(patientId)
            .withAppointments(getAppointments(patientId))
            .withPhoneNumber(patient.getPhoneNumber())
            .build();
    }

    private List<PatientAppointment> getAppointments(final UUID patientId) {

        return visitRepository.findByPatientIdInFuture(patientId)
            .map(this::createAppointment)
            .collect(Collectors.toList());
    }

    private PatientAppointment createAppointment(final Visit visit) {

        return PatientAppointment.builder()
            .withDoctorId(visit.getDoctor().getId()) // possibile demeter law wrong usage
            .withDate(visit.getAppointmentDate())
            .withVisitSlot(visit.getVisitSlot())
            .build();
    }
}
