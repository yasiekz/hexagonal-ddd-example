package io.yasiekz.github.hexagonaldddexample.application.controller;

import io.yasiekz.github.hexagonaldddexample.application.dto.UUIDResponse;
import io.yasiekz.github.hexagonaldddexample.application.dto.visit.CreateVisitRequest;
import io.yasiekz.github.hexagonaldddexample.application.dto.visit.VisitProjection;
import io.yasiekz.github.hexagonaldddexample.application.query.VisitQuery;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/visits")
@RequiredArgsConstructor
@RestController
public class VisitController {

    private final VisitQuery visitQuery;

    @PostMapping
    public UUIDResponse create(@Validated @RequestBody final CreateVisitRequest request) {

        final UUID id = UUID.randomUUID();

        return UUIDResponse.of(id);
    }

    @GetMapping("/{id}")
    public VisitProjection get(@PathVariable("id") final UUID id) {

        return visitQuery.get(id);
    }
}
