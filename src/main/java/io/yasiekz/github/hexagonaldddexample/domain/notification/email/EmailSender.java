package io.yasiekz.github.hexagonaldddexample.domain.notification.email;

import io.yasiekz.github.hexagonaldddexample.domain.email.EmailAddress;

public interface EmailSender {

    void send(EmailAddress recipient, Email email);

}
