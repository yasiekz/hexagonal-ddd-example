package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.zus;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory.Illness;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory.IllnessHistoryPort;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevelPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ZusAdapter implements InsuranceLevelPort, IllnessHistoryPort {

    private final ZusRepository zusRepository;

    @Override
    public InsuranceLevel getLvl(final HealthCareId healthCareId) {
        final ZusInsuranceResponse data = zusRepository.getData(healthCareId.getValue());

        return map(data.getInsuranceLvl());
    }

    @Override
    public List<Illness> getIllnessHistory() {

        // todo: write some code here
        return List.of();
    }

    private InsuranceLevel map(long lvl) {

        if (lvl == 100) {
            return InsuranceLevel.MAX;
        }
        if (lvl > 85) {
            return InsuranceLevel.HIGH;
        }
        if (lvl > 60) {
            return InsuranceLevel.MEDIUM;
        }
        if (lvl > 10) {
            return InsuranceLevel.LOW;
        }

        return InsuranceLevel.NONE;
    }
}
