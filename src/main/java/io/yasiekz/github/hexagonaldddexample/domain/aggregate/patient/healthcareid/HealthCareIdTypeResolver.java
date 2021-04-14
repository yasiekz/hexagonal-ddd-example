package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.validator.HealthCareIdValidator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HealthCareIdTypeResolver {

    private static final String EXCEPTION_MSG = "HealthCareId=%s is incorrect";

    private final List<HealthCareIdValidator> validators;

    public HealthCareIdType resolve(final String healthCareId) {

        return validators.stream().filter(v -> v.isValid(healthCareId))
            .findFirst()
            .map(HealthCareIdValidator::getValidatedType)
            .orElseThrow(() -> new InvalidHealthCareIdException(String.format(EXCEPTION_MSG, healthCareId)));
    }
}
