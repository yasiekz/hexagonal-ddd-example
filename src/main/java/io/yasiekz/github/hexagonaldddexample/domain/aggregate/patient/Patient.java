package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(setterPrefix = "with")
@Getter
public class Patient extends AggregateRoot {

    private final UUID id;


}
