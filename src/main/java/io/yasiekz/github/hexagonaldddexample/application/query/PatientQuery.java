package io.yasiekz.github.hexagonaldddexample.application.query;

import io.yasiekz.github.hexagonaldddexample.application.dto.patient.PatientProjection;
import java.util.List;
import java.util.UUID;

public interface PatientQuery {

    List<PatientProjection> getAll();

    PatientProjection get(final UUID id);
}
