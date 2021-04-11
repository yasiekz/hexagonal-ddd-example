package io.yasiekz.github.hexagonaldddexample.application.dto.patient;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class CreatePatientRequest {

    @NotEmpty
    @Size(max = 70)
    String name;
    @NotEmpty
    @Size(max = 70)
    String idNumber;
    @NotEmpty
    @Pattern(regexp = "^\\+48[0-9]{9}")
    String phoneNumber;
}
