package io.yasiekz.github.hexagonaldddexample.application.dto;

import java.util.UUID;
import lombok.Value;

@Value
public class UUIDResponse {

    UUID id;

    public static UUIDResponse of(final UUID id) {
        return new UUIDResponse(id);
    }
}
