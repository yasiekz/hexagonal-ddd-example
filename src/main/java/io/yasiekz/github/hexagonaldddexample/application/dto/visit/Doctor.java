package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Doctor {

     UUID id;
     String name;

}
