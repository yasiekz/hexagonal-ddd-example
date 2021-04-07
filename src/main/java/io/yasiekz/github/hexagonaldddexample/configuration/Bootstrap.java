package io.yasiekz.github.hexagonaldddexample.configuration;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.PractiseLicenseNumber;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.domain.email.EmailAddress;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
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
        doctorDb.save(createDoctor(d1Id));
        doctorDb.save(createDoctor(d2Id));
        doctorDb.save(createDoctor(d3Id));
        log.info("Doctors initialized");

        log.info("Initializing patients");
        patientDb.save(createPatient(p1Id));
        patientDb.save(createPatient(p2Id));
        patientDb.save(createPatient(p3Id));
        log.info("Patients initialized");
    }

    private Doctor createDoctor(final UUID id) {

        return Doctor.builder()
            .withId(id)
            .withSpecialization(DoctorSpecialization.SURGEON)
            .withEmailAddress(EmailAddress.of("abc@abc.pl"))
            .withPhoneNumber(PhoneNumber.of("+48123123123"))
            .withPractiseLicenseNumber(PractiseLicenseNumber.of("123123123"))
            .withName("Janusz lekarzy")
            .build();
    }

    private Patient createPatient(final UUID id) {

        return Patient.builder()
            .withId(id)
            .withName("Ktoś bardzo chory")
            .withInsuranceLevel(InsuranceLevel.MEDIUM)
            .withPhoneNumber(PhoneNumber.of("+48123123123"))
            .build();
    }
}
