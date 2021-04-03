package io.yasiekz.github.hexagonaldddexample.domain;

public interface Repository<T extends AggregateRoot> {

    void save(T aggregateRoot);

}
