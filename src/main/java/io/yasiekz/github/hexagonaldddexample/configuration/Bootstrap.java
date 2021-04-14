package io.yasiekz.github.hexagonaldddexample.configuration;

import io.yasiekz.github.hexagonaldddexample.dao.InMemoryPatientRepository;
import io.yasiekz.github.hexagonaldddexample.dao.model.Patient;
import io.yasiekz.github.hexagonaldddexample.service.InsuranceLevel;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements InitializingBean {

    private final InMemoryPatientRepository patientDb;

    @Override
    public void afterPropertiesSet() throws Exception {

        final UUID p1Id = UUID.randomUUID();
        final UUID p2Id = UUID.randomUUID();
        final UUID p3Id = UUID.randomUUID();

        log.info("Initializing patients");
        patientDb.save(createPatient(p1Id));
        patientDb.save(createPatient(p2Id));
        patientDb.save(createPatient(p3Id));
        log.info("Patients initialized");
    }

    private Patient createPatient(final UUID id) {

        return Patient.builder()
            .withId(id)
            .withName("Ktoś bardzo chory")
            .withInsuranceLevel(InsuranceLevel.MEDIUM)
            .withPhoneNumber("+48123123123")
            .build();
    }
}
