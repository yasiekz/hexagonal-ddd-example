package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HealthCareIdFactory {

    private final HealthCareIdTypeResolver resolver;

    public HealthCareId create(final String healthCareId) {
        return new HealthCareId(healthCareId, resolver.resolve(healthCareId));
    }
}
