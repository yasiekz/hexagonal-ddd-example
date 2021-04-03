package io.yasiekz.github.hexagonaldddexample.domain.patient;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(setterPrefix = "with")
@Getter
public class Patient {

    private final UUID id;


}
