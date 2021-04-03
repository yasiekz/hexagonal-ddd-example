package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Value;

@Value
public class CreateVisitRequest {

    UUID doctorId;
    UUID patientId;
    LocalDate date;
    VisitSpace visitSpace;

}
