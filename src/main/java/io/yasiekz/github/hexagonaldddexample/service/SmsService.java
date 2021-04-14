package io.yasiekz.github.hexagonaldddexample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsService {

    public void send(final String phoneNumber, final String body) {
        log.info("Sending SMS {} to {}", phoneNumber, body);
    }
}
