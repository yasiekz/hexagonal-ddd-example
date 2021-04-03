package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Visit extends AggregateRoot {

    UUID id;

}
