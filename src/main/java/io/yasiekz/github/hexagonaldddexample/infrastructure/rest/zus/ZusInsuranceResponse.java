package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.zus;

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
