package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecializationPort;
import io.yasiekz.github.hexagonaldddexample.domain.email.EmailAddress;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorFactory {

    private final DoctorSpecializationPort specializationPort;

    public Doctor create(final UUID id, final String name, final String email, final String phoneNumber,
        final String practiseLicenseNumber) {

        final var licenseNumber = PractiseLicenseNumber.of(practiseLicenseNumber);

        return Doctor.builder()
            .withId(id)
            .withPractiseLicenseNumber(licenseNumber)
            .withSpecialization(specializationPort.get(licenseNumber))
            .withPhoneNumber(PhoneNumber.of(phoneNumber))
            .withEmailAddress(EmailAddress.of(email))
            .withName(name)
            .build();
    }
}
