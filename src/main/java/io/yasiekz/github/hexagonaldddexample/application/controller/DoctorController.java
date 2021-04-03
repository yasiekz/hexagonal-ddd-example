package io.yasiekz.github.hexagonaldddexample.application.controller;

import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.CreateDoctorRequest;
import io.yasiekz.github.hexagonaldddexample.application.dto.UUIDResponse;
import io.yasiekz.github.hexagonaldddexample.application.dto.doctor.DoctorProjection;
import io.yasiekz.github.hexagonaldddexample.application.query.DoctorQuery;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/doctors")
@RequiredArgsConstructor
@RestController
public class DoctorController {

    private final DoctorQuery doctorQuery;

    @PostMapping
    public UUIDResponse create(@Validated @RequestBody final CreateDoctorRequest request) {

        final UUID id = UUID.randomUUID();

        return UUIDResponse.of(id);
    }

    @GetMapping
    public List<DoctorProjection> getAll() {
        return doctorQuery.getAll();
    }

    @GetMapping("/{id}")
    public DoctorProjection get(@PathVariable("id") final UUID id) {
        return doctorQuery.get(id);
    }
}
