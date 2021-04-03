package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.event.DoctorCreated;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.domain.email.EmailAddress;
import io.yasiekz.github.hexagonaldddexample.domain.phonenumber.PhoneNumber;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class Doctor extends AggregateRoot {

    private final UUID id;
    private final String name;
    private final PractiseLicenseNumber practiseLicenseNumber;
    private final DoctorSpecialization specialization;
    private final EmailAddress emailAddress;
    private final PhoneNumber phoneNumber;

    Doctor(final UUID id, final String name,
        final PractiseLicenseNumber practiseLicenseNumber,
        final DoctorSpecialization specialization, final EmailAddress emailAddress,
        final PhoneNumber phoneNumber) {
        this.id = id;
        this.name = name;
        this.practiseLicenseNumber = practiseLicenseNumber;
        this.specialization = specialization;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;

        registerEvent(new DoctorCreated(id));
    }
}
