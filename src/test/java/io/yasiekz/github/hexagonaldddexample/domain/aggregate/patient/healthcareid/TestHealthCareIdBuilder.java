package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid;

public class TestHealthCareIdBuilder {

    private String value;
    private HealthCareIdType type;

    public static TestHealthCareIdBuilder init() {
        return new TestHealthCareIdBuilder();
    }

    public TestHealthCareIdBuilder withValue(final String value) {
        this.value = value;
        return this;
    }

    public TestHealthCareIdBuilder withType(
        final HealthCareIdType type) {
        this.type = type;
        return this;
    }

    public HealthCareId build() {
        return new HealthCareId(value, type);
    }
}
