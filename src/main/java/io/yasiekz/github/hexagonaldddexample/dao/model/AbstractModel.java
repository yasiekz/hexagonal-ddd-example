package io.yasiekz.github.hexagonaldddexample.dao.model;

import java.util.UUID;

public class AbstractModel {

    private final UUID id;

    public AbstractModel(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
