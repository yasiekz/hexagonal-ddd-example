package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Getter
public abstract class VisitPart<T extends Appointment> {

    List<T> appointments;

    public VisitPart(final List<T> appointments) {
        this.appointments = appointments;
    }

    public boolean isSlotFree(final VisitSlot visitSlot, final LocalDate appointmentDate) {

        return appointments
            .stream()
            .noneMatch(a -> a.visitSlot.equals(visitSlot) && a.date.equals(appointmentDate));
    }

}
