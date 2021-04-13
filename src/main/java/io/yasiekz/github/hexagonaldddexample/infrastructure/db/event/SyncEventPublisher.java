package io.yasiekz.github.hexagonaldddexample.infrastructure.db.event;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.event.DoctorCreated;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.notification.DoctorNotification;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.notification.DoctorNotificationProcessor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.event.VisitCreated;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.notification.VisitNotification;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.notification.VisitNotificationProcessor;
import io.yasiekz.github.hexagonaldddexample.domain.event.Event;
import io.yasiekz.github.hexagonaldddexample.domain.event.EventPublisher;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryDoctorRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.db.InMemoryVisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
// simple and crude implementation of publish / subscribe. use something better :D
public class SyncEventPublisher implements EventPublisher {

    private final InMemoryDoctorRepository doctorRepository;
    private final InMemoryVisitRepository visitRepository;
    private final DoctorNotificationProcessor doctorNotificationProcessor;
    private final VisitNotificationProcessor visitNotificationProcessor;


    @Override
    // todo: use here some
    public void publish(final Event event) {

        log.info("Event published: {}", event);

        if (event instanceof DoctorCreated) {
            final Doctor doctor = doctorRepository.get(((DoctorCreated) event).getDoctorId()).orElseThrow();
            doctorNotificationProcessor.notify(new DoctorNotification(doctor));
        }

        if (event instanceof VisitCreated) {
            final Visit visit = visitRepository.get(((VisitCreated) event).getVisitId()).orElseThrow();
            visitNotificationProcessor.notify(new VisitNotification(visit));
        }
    }
}
