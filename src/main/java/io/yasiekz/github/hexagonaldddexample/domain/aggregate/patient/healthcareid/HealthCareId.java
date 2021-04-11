package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

import lombok.Value;

@Value
public class HealthCareId {

    private static final String PREFIX = "PL";

    String value;

    private HealthCareId(final String value) {
        if (!isValid(value)) {
            throw new InvalidHealthCareIdException(String.format("Health care ID=%s is not valid", value));
        }
        this.value = value;
    }

    public static HealthCareId of(final String value) {
        return new HealthCareId(value);
    }

    public boolean isValid(final String id) {

        return id.length() > 5
            && id.startsWith(PREFIX);
    }
}
