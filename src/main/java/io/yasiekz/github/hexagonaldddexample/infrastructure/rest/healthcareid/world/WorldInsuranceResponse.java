package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.world;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class WorldInsuranceResponse {

    String id;
    LocalDate dateOfBirth;

}
