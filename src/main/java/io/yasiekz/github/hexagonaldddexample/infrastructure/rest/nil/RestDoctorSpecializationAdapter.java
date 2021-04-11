package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.PractiseLicenseNumber;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecializationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestDoctorSpecializationAdapter implements DoctorSpecializationPort {

    private final RestNilRepository nilRepository;

    @Override
    public DoctorSpecialization get(final PractiseLicenseNumber practiseLicenseNumber) {

        return map(nilRepository.getData(practiseLicenseNumber.getValue()).getSpecialization());
    }

    private DoctorSpecialization map(final Specialization specialization) {

        switch (specialization) {
            case B12:
                return DoctorSpecialization.ONCOLOGIST;
            case B55:
                return DoctorSpecialization.SURGEON;
            case B66:
                return DoctorSpecialization.PROCTOLOGIST;
            default:
                throw new IllegalArgumentException(
                    String.format("Specialization %s cannot be mapped to domain model", specialization));
        }
    }
}
