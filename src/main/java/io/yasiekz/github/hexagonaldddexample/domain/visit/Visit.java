package io.yasiekz.github.hexagonaldddexample.domain.visit;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(setterPrefix = "with")
@Getter
public class Visit {

    UUID id;

}
