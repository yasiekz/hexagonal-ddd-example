package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdFactory;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevelPort;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public final class PatientFactory {

    private static final List<InsuranceLevel> ACCEPTED_INSURANCE_LEVELS = List.of(InsuranceLevel.MAX,
        InsuranceLevel.HIGH, InsuranceLevel.MEDIUM);

    private final InsuranceLevelPort insuranceLevelPort;
    private final HealthCareIdFactory healthCareIdFactory;

    public Patient create(final UUID id, final String name, final String healthCareId, final String phoneNumber) {

        final HealthCareId domainHealthCareId = healthCareIdFactory.create(healthCareId);
        final InsuranceLevel insuranceLevel = insuranceLevelPort.getLvl(domainHealthCareId);

        if (!ACCEPTED_INSURANCE_LEVELS.contains(insuranceLevel)) {
            throw new CannotCreatePatientException(
                String.format("Patient cannot be created due to his insufficient insurance lvl=%s", insuranceLevel));
        }

        return Patient.builder()
            .withId(id)
            .withName(name)
            .withPhoneNumber(PhoneNumber.of(phoneNumber))
            .withInsuranceLevel(insuranceLevel)
            .withHealthCareId(domainHealthCareId)
            .build();
    }
}
