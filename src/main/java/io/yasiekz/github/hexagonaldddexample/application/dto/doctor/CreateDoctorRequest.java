package io.yasiekz.github.hexagonaldddexample.application.dto.doctor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class CreateDoctorRequest {

    @NotEmpty
    @Size(max = 70)
    String name;
    @NotEmpty
    @Pattern(regexp = "^\\+48[0-9]{9}")
    String phoneNumber;
    @NotEmpty
    @Size(max = 70)
    @Pattern(regexp = "^[0-9a-z.]{2,}@[a-z0-9]*\\.[a-z]*$")
    String email;
    @NotEmpty
    String practiseLicenseNumber;

}
