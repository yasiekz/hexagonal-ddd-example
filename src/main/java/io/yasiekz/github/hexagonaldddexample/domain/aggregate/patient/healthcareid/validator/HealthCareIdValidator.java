package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.validator;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;

public interface HealthCareIdValidator {

    boolean isValid(final String healthCareId);

    HealthCareIdType getValidatedType();

}
