package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.zus;

public interface ZusRepository {

    ZusInsuranceResponse getData(final String id);

}
