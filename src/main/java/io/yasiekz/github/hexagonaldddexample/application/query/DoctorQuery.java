package io.yasiekz.github.hexagonaldddexample.application.query;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.DoctorProjection;
import java.util.List;
import java.util.UUID;

public interface DoctorQuery {

    List<DoctorProjection> getAll();

    DoctorProjection get(final UUID id);
}
