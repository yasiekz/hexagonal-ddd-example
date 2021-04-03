package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CreateVisitRequest {

    @NotNull
    UUID doctorId;
    @NotNull
    UUID patientId;
    @FutureOrPresent
    LocalDate date;
    @NotNull
    VisitSpace visitSpace;

}
