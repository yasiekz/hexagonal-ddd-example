package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

import lombok.Value;

@Value
public class CreateDoctorRequest {

    String name;
    String practiseLicenseNumber;

}
