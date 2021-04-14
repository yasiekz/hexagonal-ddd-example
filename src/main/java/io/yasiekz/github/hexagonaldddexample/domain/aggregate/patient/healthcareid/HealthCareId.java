package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class HealthCareId {

    String value;
    HealthCareIdType type;
}
