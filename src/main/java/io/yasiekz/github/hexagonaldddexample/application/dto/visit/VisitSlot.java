package io.yasiekz.github.hexagonaldddexample.application.dto.visit;

public enum VisitSlot {

    FIRST,
    SECOND,
    THIRD,
    FOURTH;

    public io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitSlot toDomainSlot() {
        return io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitSlot.valueOf(name());
    }

    public VisitSlot fromDomainSlot(
        final io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.VisitSlot visitSlot) {

        return VisitSlot.valueOf(visitSlot.name());
    }
}
