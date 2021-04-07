package io.yasiekz.github.hexagonaldddexample.infrastructure.random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.PractiseLicenseNumber;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.doctor.specialization.DoctorSpecialization;
import io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil.NilResponse;
import io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil.RestNilRepository;
import io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil.Specialization;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestDoctorSpecializationAdapterTest {

    private static final String LICENSE_NUMBER_VALUE = "123123123";
    private static final PractiseLicenseNumber LICENSE_NUMBER = PractiseLicenseNumber.of(LICENSE_NUMBER_VALUE);

    @Mock
    private RestNilRepository repository;

    private RestDoctorSpecializationAdapter adapter;

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(Specialization.B12, DoctorSpecialization.ONCOLOGIST),
            Arguments.of(Specialization.B55, DoctorSpecialization.SURGEON),
            Arguments.of(Specialization.B66, DoctorSpecialization.PROCTOLOGIST)
        );
    }

    @BeforeEach
    void setUp() {
        adapter = new RestDoctorSpecializationAdapter(repository);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    @DisplayName("Should correctly map values")
    void testHappyPath(final Specialization repoValue, final DoctorSpecialization expected) {

        // when
        final NilResponse response = NilResponse.builder()
            .withLicenseNumber(LICENSE_NUMBER_VALUE)
            .withSpecialization(repoValue)
            .build();
        when(repository.getData(any())).thenReturn(response);

        // when
        final DoctorSpecialization result = adapter.get(LICENSE_NUMBER);

        // then
        assertEquals(expected, result);
        verify(repository).getData(eq(LICENSE_NUMBER_VALUE));
    }

}
