package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class VisitProjection {

    UUID id;
    LocalDate date;
    VisitSpace visitSpace;
    Doctor doctor;
    Patient patient;

}
