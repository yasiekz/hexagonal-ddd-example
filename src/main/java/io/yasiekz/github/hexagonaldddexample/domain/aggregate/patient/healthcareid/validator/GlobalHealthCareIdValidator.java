package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.validator;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import org.springframework.stereotype.Component;

@Component
public class GlobalHealthCareIdValidator implements HealthCareIdValidator {

    @Override
    public boolean isValid(final String healthCareId) {
        return healthCareId.length() > 20;
    }

    @Override
    public HealthCareIdType getValidatedType() {
        return HealthCareIdType.GLOBAL;
    }
}
