package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public class PractiseLicenseNumber {

    String value;

}
