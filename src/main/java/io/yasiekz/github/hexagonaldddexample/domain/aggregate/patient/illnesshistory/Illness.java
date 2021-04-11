package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory;

import java.time.LocalDate;
import lombok.Value;

@Value
public class Illness {

    String name;
    String description;
    LocalDate diagnosedAt;

}
