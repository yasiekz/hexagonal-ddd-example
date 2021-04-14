package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevelPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@RequiredArgsConstructor
public class InsuranceLevelAdapterComposite implements InsuranceLevelPort {

    private final List<InsuranceLevelConcreteAdapter> adapters;

    @Override
    public InsuranceLevel getLvl(final HealthCareId healthCareId) {

        return adapters.stream()
            .filter(a -> a.canHandle(healthCareId.getType()))
            .findFirst()
            .map(a -> a.getLvl(healthCareId))
            .orElseThrow(() -> new IllegalArgumentException(
                String.format("Cannot find adapter for type =%s", healthCareId.getType())));
    }
}
