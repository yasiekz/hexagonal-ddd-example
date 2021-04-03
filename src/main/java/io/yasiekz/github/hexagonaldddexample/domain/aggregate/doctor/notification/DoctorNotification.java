package io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.notification;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.Doctor;
import lombok.Value;

@Value
public class DoctorNotification {

    Doctor doctor;

}
