package io.yasiekz.github.hexagonaldddexample.dao.model;

import io.yasiekz.github.hexagonaldddexample.service.InsuranceLevel;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Patient extends AbstractModel {

    private final String name;
    private final InsuranceLevel insuranceLevel;
    private final String phoneNumber;
    private final String healthCareId;

    @Builder(setterPrefix = "with")
    public Patient(final UUID id, final String name,
        final InsuranceLevel insuranceLevel, final String phoneNumber, final String healthCareId) {
        super(id);
        this.name = name;
        this.insuranceLevel = insuranceLevel;
        this.phoneNumber = phoneNumber;
        this.healthCareId = healthCareId;
    }
}
