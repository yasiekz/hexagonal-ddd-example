package io.yasiekz.github.hexagonaldddexample.domain.doctor;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(setterPrefix = "with")
@Getter
public class Doctor {

    private final UUID id;


}
