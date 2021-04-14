package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.zus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.TestHealthCareIdBuilder;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestInsuranceLevelAdapterTest {

    private static final HealthCareId healthCareid = TestHealthCareIdBuilder.init().withValue("PL123123123").withType(
        HealthCareIdType.PL).build();

    @Mock
    RestZusRepository repository;

    private ZusAdapter adapter;

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(5, InsuranceLevel.NONE),
            Arguments.of(12, InsuranceLevel.LOW),
            Arguments.of(66, InsuranceLevel.MEDIUM),
            Arguments.of(79, InsuranceLevel.MEDIUM),
            Arguments.of(90, InsuranceLevel.HIGH),
            Arguments.of(100, InsuranceLevel.MAX)
        );
    }

    @BeforeEach
    void setUp() {
        adapter = new ZusAdapter(repository);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void testMapInsuranceLvlCorrectly(final int responseLvl, final InsuranceLevel expectedValue) {

        // given
        final ZusInsuranceResponse response = ZusInsuranceResponse.builder()
            .withInsuranceLvl(responseLvl)
            .build();
        when(repository.getData(any())).thenReturn(response);

        // when
        final InsuranceLevel result = adapter.getLvl(healthCareid);

        // then
        assertEquals(expectedValue, result);
    }
}
