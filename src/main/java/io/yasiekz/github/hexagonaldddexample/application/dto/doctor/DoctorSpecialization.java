package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

public enum DoctorSpecialization {

    ONCOLOGIST,
    PROCTOLOGIST,
    SURGEON;

    public DoctorSpecialization from(
        io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization specialization) {

        return DoctorSpecialization.valueOf(specialization.name());
    }
}
