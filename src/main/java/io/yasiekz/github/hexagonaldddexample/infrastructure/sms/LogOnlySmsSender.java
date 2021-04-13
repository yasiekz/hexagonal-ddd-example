package io.yasiekz.github.hexagonaldddexample.infrastructure.sms;

import io.yasiekz.github.hexagonaldddexample.domain.notification.sms.Sms;
import io.yasiekz.github.hexagonaldddexample.domain.notification.sms.SmsSender;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogOnlySmsSender implements SmsSender {

    @Override
    public void send(final PhoneNumber phoneNumber, final Sms sms) {
        log.info("Sending SMS {} to {}", phoneNumber, sms);
    }
}
