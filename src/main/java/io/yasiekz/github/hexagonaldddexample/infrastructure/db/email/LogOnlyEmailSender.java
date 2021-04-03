package io.yasiekz.github.hexagonaldddexample.infrastructure.db.email;

import io.yasiekz.github.hexagonaldddexample.domain.email.EmailAddress;
import io.yasiekz.github.hexagonaldddexample.domain.notification.email.Email;
import io.yasiekz.github.hexagonaldddexample.domain.notification.email.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogOnlyEmailSender implements EmailSender {

    @Override
    public void send(final EmailAddress recipient, final Email email) {

        log.info("Sending email {} to {}", recipient, email);

    }
}
