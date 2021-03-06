package io.yasiekz.github.hexagonaldddexample.infrastructure.db;

import io.yasiekz.github.hexagonaldddexample.domain.AggregateRoot;
import io.yasiekz.github.hexagonaldddexample.domain.Repository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ImMemoryRepository<T extends AggregateRoot> implements Repository<T> {

    protected final ConcurrentHashMap<UUID, T> concurrentHashMap = new ConcurrentHashMap<>();

    public final Collection<T> getAll() {
        return concurrentHashMap.values();
    }

    public final Optional<T> get(final UUID id) {
        if (concurrentHashMap.containsKey(id)) {
            return Optional.of(concurrentHashMap.get(id));
        }

        return Optional.empty();
    }

    public final void delete(UUID id) {
        concurrentHashMap.remove(id);
    }

    @Override
    public void save(final T doctor) {
        save(doctor.getId(), doctor);
    }

    protected final T save(UUID id, T object) {
        concurrentHashMap.putIfAbsent(id, object);
        return object;
    }
}
