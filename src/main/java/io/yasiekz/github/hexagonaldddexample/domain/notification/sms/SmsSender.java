package io.yasiekz.github.hexagonaldddexample.domain.notification.sms;

import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;

public interface SmsSender {

    void send(PhoneNumber phoneNumber, Sms sms);

}
