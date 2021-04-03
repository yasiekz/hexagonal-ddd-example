package io.yasiekz.github.hexagonaldddexample.domain.notification.email;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@ToString
@EqualsAndHashCode
public class Email {

    String title;
    String body;

}
