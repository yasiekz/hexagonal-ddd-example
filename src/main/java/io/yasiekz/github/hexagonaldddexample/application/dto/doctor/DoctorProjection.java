package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class DoctorProjection {

    UUID id;
    String name;
    String phoneNumber;
    String email;
    DoctorSpecialization specialization;

}
