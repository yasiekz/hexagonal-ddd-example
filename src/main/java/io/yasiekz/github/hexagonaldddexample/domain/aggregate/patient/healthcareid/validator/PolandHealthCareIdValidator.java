package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.validator;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import org.springframework.stereotype.Component;

@Component
public class PolandHealthCareIdValidator implements HealthCareIdValidator {

    private static final String PREFIX = "PL";

    @Override
    public boolean isValid(final String healthCareId) {
        return healthCareId.length() > 5
            && healthCareId.startsWith(PREFIX);
    }

    @Override
    public HealthCareIdType getValidatedType() {
        return HealthCareIdType.PL;
    }
}
