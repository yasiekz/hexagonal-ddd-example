package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;

public interface InsuranceLevelPort {

    InsuranceLevel getLvl(HealthCareId healthCareId);

}
