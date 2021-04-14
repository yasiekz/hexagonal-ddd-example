package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.world;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory.Illness;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory.IllnessHistoryPort;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.InsuranceLevelConcreteAdapter;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorldAdapter implements InsuranceLevelConcreteAdapter, IllnessHistoryPort {

    private final WorldRepository worldRepository;

    @Override
    public InsuranceLevel getLvl(final HealthCareId healthCareId) {
        final WorldInsuranceResponse data = worldRepository.getData(healthCareId.getValue());

        return map(data.getDateOfBirth());
    }

    @Override
    public List<Illness> getIllnessHistory() {

        // todo: write some code here
        return List.of();
    }

    @Override
    public boolean canHandle(final HealthCareIdType healthCareIdType) {
        return HealthCareIdType.PL.equals(healthCareIdType);
    }

    private InsuranceLevel map(final LocalDate dateOfBirth) {

        final LocalDate now = LocalDate.now();
        final LocalDate ago80 = now.minusYears(80);

        if (dateOfBirth.isBefore(ago80)) {
            return InsuranceLevel.HIGH;
        }

        return InsuranceLevel.MEDIUM;
    }
}
