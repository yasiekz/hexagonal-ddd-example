package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.zus;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class ZusInsuranceResponse {

    String id;
    long insuranceLvl;
    LocalDate createdAt;

}
