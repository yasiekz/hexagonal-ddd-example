package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevelPort;

public interface InsuranceLevelConcreteAdapter extends InsuranceLevelPort {

    boolean canHandle(final HealthCareIdType healthCareIdType);

}
