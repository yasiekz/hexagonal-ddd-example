package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Patient {

    UUID id;
    String name;

}
