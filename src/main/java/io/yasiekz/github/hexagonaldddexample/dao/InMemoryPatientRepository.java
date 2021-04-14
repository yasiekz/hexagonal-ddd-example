package io.yasiekz.github.hexagonaldddexample.dao;

import io.yasiekz.github.hexagonaldddexample.dao.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class InMemoryPatientRepository extends ImMemoryRepository<Patient> {


}
