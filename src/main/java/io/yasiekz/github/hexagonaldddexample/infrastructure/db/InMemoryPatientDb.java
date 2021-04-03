package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.patient.Patient;
import org.springframework.stereotype.Component;

@Component
public class InMemoryPatientDb extends ImMemoryDb<Patient> {


}
