package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Appointment {

    VisitSlot visitSlot;
    LocalDate date;

}
