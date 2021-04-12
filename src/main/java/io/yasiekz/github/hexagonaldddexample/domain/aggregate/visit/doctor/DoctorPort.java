package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor;

import java.util.UUID;

public interface DoctorPort {

    Doctor get(final UUID doctorId);

}
