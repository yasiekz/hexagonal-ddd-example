package io.yasiekz.github.hexagonaldddexample.application.query;

import java.util.List;
import java.util.UUID;

public interface Query<T> {

    List<T> getAll();

    T get(final UUID id);

}
