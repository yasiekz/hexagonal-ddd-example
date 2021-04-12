package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient;

import java.util.UUID;

public interface PatientPort {

    Patient get(final UUID patientId);

}
