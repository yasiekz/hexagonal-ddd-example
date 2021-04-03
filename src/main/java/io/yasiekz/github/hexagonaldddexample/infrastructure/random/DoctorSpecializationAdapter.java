package io.yasiekz.github.hexagonaldddexample.infrastructure.random;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.PractiseLicenseNumber;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecializationPort;
import org.springframework.stereotype.Component;

@Component
public class DoctorSpecializationAdapter implements DoctorSpecializationPort {

    @Override
    public DoctorSpecialization get(final PractiseLicenseNumber practiseLicenseNumber) {
        return DoctorSpecialization.ONCOLOGIST;
    }
}
