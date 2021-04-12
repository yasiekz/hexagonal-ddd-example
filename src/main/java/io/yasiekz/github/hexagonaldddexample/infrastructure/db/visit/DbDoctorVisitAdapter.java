package io.yasiekz.github.hexagonaldddexample.infrastructure.db.visit;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorAppointment;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorPort;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryDoctorRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryVisitRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbDoctorVisitAdapter implements DoctorPort {

    private final InMemoryDoctorRepository doctorRepository;
    private final InMemoryVisitRepository visitRepository;

    @Override
    public Doctor get(final UUID doctorId) {

        final var doctor = doctorRepository.get(doctorId)
            .orElseThrow(
                () -> new IllegalArgumentException(String.format("Could not fetch doctor with ID=%s", doctorId)));

        return Doctor.builder()
            .withId(doctorId)
            .withAppointments(getAppointments(doctorId))
            .build();
    }

    private List<DoctorAppointment> getAppointments(final UUID doctorId) {

        return visitRepository.findByDoctorIdInFuture(doctorId)
            .map(this::createAppointment)
            .collect(Collectors.toList());
    }

    private DoctorAppointment createAppointment(final Visit visit) {

        return DoctorAppointment.builder()
            .withPatientId(visit.getPatient().getId()) // possibile demeter law wrong usage
            .withDate(visit.getAppointmentDate())
            .withVisitSlot(visit.getVisitSlot())
            .build();
    }
}
