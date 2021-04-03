package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.notification;

import io.yasiekz.github.hexagonaldddexample.domain.notification.email.Email;
import io.yasiekz.github.hexagonaldddexample.domain.notification.email.EmailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public final class DoctorNotificationProcessor {

    private final EmailSender emailSender;

    public void notify(DoctorNotification notification) {

        log.info("Notifying doctor with ID={}", notification.getDoctor().getId());
        final Email email = Email.builder()
            .withTitle("Congratulations! You have been added to our system")
            .withBody("You are luckiest guy in the world!!!")
            .build();

        emailSender.send(notification.getDoctor().getEmailAddress(), email);
    }
}
