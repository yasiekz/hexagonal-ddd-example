package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil;

import org.springframework.stereotype.Component;

@Component
public class RestNilRepository {

    public NilResponse getData(String licenseNumber) {

        return NilResponse.builder()
            .withId(555L)
            .withEducation("UJ")
            .withName("Janusz lekarz")
            .withLicenseNumber(licenseNumber)
            .withSpecialization(Specialization.random())
            .build();
    }
}
