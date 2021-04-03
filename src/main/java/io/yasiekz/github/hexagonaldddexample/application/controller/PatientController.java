package io.yasiekz.github.hexagonaldddexample.application.controller;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.CreateDoctorRequest;
import io.yasiekz.github.hexagonaldddexample.application.dto.UUIDResponse;
import io.yasiekz.github.hexagonaldddexample.application.dto.patient.PatientProjection;
import io.yasiekz.github.hexagonaldddexample.application.query.PatientQuery;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/patients")
@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientQuery patientQuery;

    @PostMapping
    public UUIDResponse create(@Validated @RequestBody final CreateDoctorRequest request) {

        final UUID id = UUID.randomUUID();

        return UUIDResponse.of(id);
    }

    @GetMapping
    public List<PatientProjection> getAll() {
        return patientQuery.getAll();
    }

    @GetMapping("/{id}")
    public PatientProjection get(@PathVariable("id") final UUID id) {
        return patientQuery.get(id);
    }
}
