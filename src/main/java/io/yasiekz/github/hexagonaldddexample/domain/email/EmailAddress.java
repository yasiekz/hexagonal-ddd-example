package io.yasiekz.github.hexagonaldddexample.domain.email;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public class EmailAddress {

    String value;

}
