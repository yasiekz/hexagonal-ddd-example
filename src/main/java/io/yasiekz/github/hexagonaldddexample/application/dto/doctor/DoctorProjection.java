package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class DoctorProjection {

    UUID id;
    String name;
    DoctorSpecialization specialization;

}
