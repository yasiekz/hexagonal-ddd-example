package io.yasiekz.github.hexagonaldddexample.application.controller;

import io.yasiekz.github.hexagonaldddexample.application.dto.UUIDResponse;
import io.yasiekz.github.hexagonaldddexample.application.dto.patient.CreatePatientRequest;
import io.yasiekz.github.hexagonaldddexample.application.dto.patient.PatientProjection;
import io.yasiekz.github.hexagonaldddexample.service.PatientMapper;
import io.yasiekz.github.hexagonaldddexample.service.PatientService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/patients")
@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping
    public UUIDResponse create(@Validated @RequestBody final CreatePatientRequest request) {

        final UUID id = UUID.randomUUID();
        patientService.create(id, request.getIdNumber(), request.getPhoneNumber());

        return UUIDResponse.of(id);
    }

    @GetMapping
    public List<PatientProjection> getAll() {
        return patientService.getAll().stream().map(patientMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PatientProjection get(@PathVariable("id") final UUID id) {
        return patientMapper.map(patientService.get(id));
    }
}
