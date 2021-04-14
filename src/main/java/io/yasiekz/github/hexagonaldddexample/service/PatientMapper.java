package io.yasiekz.github.hexagonaldddexample.service;

import io.yasiekz.github.hexagonaldddexample.application.dto.patient.PatientProjection;
import io.yasiekz.github.hexagonaldddexample.dao.model.Patient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PatientMapper {

    private final PatientService patientService;

    public PatientProjection map(final Patient patient) {

        // map response from service
        return null;
    }
}
