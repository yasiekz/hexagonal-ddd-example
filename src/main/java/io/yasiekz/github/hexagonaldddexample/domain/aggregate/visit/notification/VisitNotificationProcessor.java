package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.notification;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.Visit;
import io.yasiekz.github.hexagonaldddexample.domain.notification.email.Email;
import io.yasiekz.github.hexagonaldddexample.domain.notification.email.EmailSender;
import io.yasiekz.github.hexagonaldddexample.domain.notification.sms.Sms;
import io.yasiekz.github.hexagonaldddexample.domain.notification.sms.SmsSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public final class VisitNotificationProcessor {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public void notify(VisitNotification notification) {

        log.info("Sending notifications for visit withId={}", notification.getVisit().getId());
        sendEmailToDoctor(notification.getVisit());
        sendSmsToPatient(notification.getVisit());
    }

    private void sendEmailToDoctor(final Visit visit) {

        final Email email = Email.builder()
            .withTitle("Congratulations! You have an appointment")
            .withBody("You are luckiest guy in the world!!!")
            .build();

        emailSender.send(visit.getDoctor().getEmailAddress(), email);
        log.info("Email to {} for visit with ID={} has been sent", "", visit.getId());
    }

    private void sendSmsToPatient(final Visit visit) {

        final Sms sms = Sms.builder()
            .withBody("Your appointment has been created :)")
            .build();

        smsSender.send(visit.getPatient().getPhoneNumber(), sms);
        log.info("Sms to {} for visit with ID={} has been sent", "", visit.getId());
    }
}
