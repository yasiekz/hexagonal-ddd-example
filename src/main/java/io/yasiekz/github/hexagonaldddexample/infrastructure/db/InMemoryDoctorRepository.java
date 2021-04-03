package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import org.springframework.stereotype.Component;

@Component
public class InMemoryDoctorRepository extends ImMemoryRepository<Doctor> {


}
