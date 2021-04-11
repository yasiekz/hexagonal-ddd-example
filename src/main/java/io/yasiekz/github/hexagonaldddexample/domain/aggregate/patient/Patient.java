package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.event.PatientCreated;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class Patient extends AggregateRoot {

    private final UUID id;
    private final String name;
    private final InsuranceLevel insuranceLevel;
    private final PhoneNumber phoneNumber;
    private final HealthCareId healthCareId;

    Patient(final UUID id, final String name,
        final InsuranceLevel insuranceLevel, final PhoneNumber phoneNumber,
        final HealthCareId healthCareId) {
        this.id = id;
        this.name = name;
        this.insuranceLevel = insuranceLevel;
        this.phoneNumber = phoneNumber;
        this.healthCareId = healthCareId;

        registerEvent(new PatientCreated(id));
    }
}
