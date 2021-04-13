package io.yasiekz.github.hexagonaldddexample.domain.notification.sms;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@ToString
@EqualsAndHashCode
public class Sms {

    String body;

}
