package io.yasiekz.github.hexagonaldddexample.application.handler.doctor;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.CreateDoctorRequest;
import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.DoctorFactory;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateDoctorHandler {

    private final DoctorFactory doctorFactory;
    private final DomainRepository<Doctor> repository;

    public void create(UUID id, CreateDoctorRequest request) {

        final Doctor doctor = doctorFactory.create(
            id,
            request.getName(),
            request.getEmail(),
            request.getPhoneNumber(),
            request.getPractiseLicenseNumber()
        );

        repository.save(doctor);

        // here we can publish application events, which is handled by application layer
        // for example to update projections in read model if we want to
    }
}
