package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.visit.Visit;
import org.springframework.stereotype.Component;

@Component
public class InMemoryVisitRepository extends ImMemoryRepository<Visit> {

}
