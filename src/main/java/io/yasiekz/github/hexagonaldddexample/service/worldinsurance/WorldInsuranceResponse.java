package io.yasiekz.github.hexagonaldddexample.service.worldinsurance;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class WorldInsuranceResponse {

    String id;
    LocalDate dateOfBirth;

}
