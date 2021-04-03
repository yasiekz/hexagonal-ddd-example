package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.PractiseLicenseNumber;

public interface DoctorSpecializationPort {

    DoctorSpecialization get(PractiseLicenseNumber practiseLicenseNumber);

}
