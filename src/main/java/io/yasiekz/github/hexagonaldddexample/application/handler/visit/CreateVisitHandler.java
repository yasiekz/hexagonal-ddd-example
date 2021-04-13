package io.yasiekz.github.hexagonaldddexample.application.handler.visit;

import io.yasiekz.github.hexagonaldddexample.application.dto.visit.CreateVisitRequest;
import io.yasiekz.github.hexagonaldddexample.domain.DomainRepository;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitFactory;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateVisitHandler {

    private final VisitFactory visitFactory;
    private final DomainRepository<Visit> visitDomainRepository;

    public void create(UUID id, CreateVisitRequest request) {

        final Visit visit = visitFactory.create(
            id,
            request.getPatientId(),
            request.getDoctorId(),
            request.getVisitSpace().toDomainSlot(),
            request.getDate()
        );

        visitDomainRepository.save(visit);

        // here we can publish application events, which is handled by application layer
        // for example to update projections in read model if we want to
    }
}
