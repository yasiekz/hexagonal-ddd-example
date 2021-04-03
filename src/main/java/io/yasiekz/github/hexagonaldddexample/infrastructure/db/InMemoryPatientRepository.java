package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.Patient;
import org.springframework.stereotype.Component;

@Component
public class InMemoryPatientRepository extends ImMemoryRepository<Patient> {


}
