package io.yasiekz.github.hexagonaldddexample.application.dto.patient;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class PatientProjection {

    UUID id;
    String name;
    String pesel;

}
