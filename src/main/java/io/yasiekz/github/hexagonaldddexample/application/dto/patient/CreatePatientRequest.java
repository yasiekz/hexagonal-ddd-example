package io.yasiekz.github.hexagonaldddexample.application.dto.patient;

import lombok.Value;

@Value
public class CreatePatientRequest {

    String name;
    String pesel;

}
