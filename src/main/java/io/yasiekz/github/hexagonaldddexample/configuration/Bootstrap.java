package io.yasiekz.github.hexagonaldddexample.configuration;

import io.yasiekz.github.hexagonaldddexample.domain.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryDoctorRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryPatientRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements InitializingBean {

    private final InMemoryDoctorRepository doctorDb;
    private final InMemoryPatientRepository patientDb;

    @Override
    public void afterPropertiesSet() throws Exception {

        final UUID d1Id = UUID.randomUUID();
        final UUID d2Id = UUID.randomUUID();
        final UUID d3Id = UUID.randomUUID();

        final UUID p1Id = UUID.randomUUID();
        final UUID p2Id = UUID.randomUUID();
        final UUID p3Id = UUID.randomUUID();

        log.info("Initializing doctors");
        doctorDb.save(d1Id, new Doctor(d1Id));
        doctorDb.save(d2Id, new Doctor(d2Id));
        doctorDb.save(d3Id, new Doctor(d3Id));
        log.info("Doctors initialized");

        log.info("Initializing patients");
        patientDb.save(p1Id, new Patient(p1Id));
        patientDb.save(p2Id, new Patient(p2Id));
        patientDb.save(p3Id, new Patient(p3Id));
        log.info("Patients initialized");
    }
}
