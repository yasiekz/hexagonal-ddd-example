package io.yasiekz.github.hexagonaldddexample.domain.phonenumber;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
@ToString
public class PhoneNumber {

    String value;

}
