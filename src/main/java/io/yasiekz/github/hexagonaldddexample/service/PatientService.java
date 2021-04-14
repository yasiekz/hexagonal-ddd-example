package io.yasiekz.github.hexagonaldddexample.service;

import io.yasiekz.github.hexagonaldddexample.dao.InMemoryPatientRepository;
import io.yasiekz.github.hexagonaldddexample.dao.model.Patient;
import io.yasiekz.github.hexagonaldddexample.exception.CannotCreatePatientException;
import io.yasiekz.github.hexagonaldddexample.exception.PatientNotFoundException;
import io.yasiekz.github.hexagonaldddexample.service.zus.ZusInsuranceResponse;
import io.yasiekz.github.hexagonaldddexample.service.zus.ZusService;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PatientService {

    private static final List<InsuranceLevel> ACCEPTED_INSURANCE_LEVELS = List.of(InsuranceLevel.MAX,
        InsuranceLevel.HIGH, InsuranceLevel.MEDIUM);

    private final ZusService zusService;
    private final InMemoryPatientRepository patientRepository;
    private final SmsService smsService;

    // how much tests are needed to cover this method?
    public Patient create(final UUID id, final String idNumber, final String phoneNumber) {

        final InsuranceLevel insuranceLevel = calculateInsuranceLvl(idNumber);
        if (!ACCEPTED_INSURANCE_LEVELS.contains(insuranceLevel)) {
            throw new CannotCreatePatientException(
                String.format("Patient cannot be created due to his insufficient insurance lvl=%s", insuranceLevel));
        }

        final Patient patient = Patient.builder()
            .withId(id)
            .withPhoneNumber(phoneNumber)
            .withHealthCareId(idNumber)
            .withInsuranceLevel(insuranceLevel)
            .build();

        patientRepository.save(patient);
        smsService.send(phoneNumber, "Congratulations");
        return patient;
    }

    public Patient get(final UUID id) {
        return patientRepository.get(id)
            .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with Id=%s not found", id)));
    }

    public Collection<Patient> getAll() {

        return patientRepository.getAll();
    }

    private InsuranceLevel calculateInsuranceLvl(final String idNumber) {

        final ZusInsuranceResponse data = zusService.getData(idNumber);

        if (data.getInsuranceLvl() == 100) {
            return InsuranceLevel.MAX;
        }
        if (data.getInsuranceLvl() > 85) {
            return InsuranceLevel.HIGH;
        }
        if (data.getInsuranceLvl() > 60) {
            return InsuranceLevel.MEDIUM;
        }
        if (data.getInsuranceLvl() > 10) {
            return InsuranceLevel.LOW;
        }

        return InsuranceLevel.NONE;

    }
}
