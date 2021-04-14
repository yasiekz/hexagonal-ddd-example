package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareId;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdFactory;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.HealthCareIdType;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.healthcareid.TestHealthCareIdBuilder;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevel;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.insurance.InsuranceLevelPort;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PatientFactoryTest {

    private static final UUID PATIENT_ID = UUID.randomUUID();
    private static final String PATIENT_NAME = "Wege Rys";
    private static final String PATIENT_HEALTH_CARE_ID = "PL123121323";
    private static final String PATIENT_PHONE_NUMBER = "+48123123123";

    @Mock
    private InsuranceLevelPort port;

    @Mock
    private HealthCareIdFactory healthCareIdFactory;

    private PatientFactory patientFactory;

    @BeforeEach
    void setUp() {
        final HealthCareId healthCareId = TestHealthCareIdBuilder.init()
            .withType(HealthCareIdType.PL)
            .withValue(PATIENT_HEALTH_CARE_ID)
            .build();
        when(healthCareIdFactory.create(any())).thenReturn(healthCareId);
        patientFactory = new PatientFactory(port, healthCareIdFactory);
    }

    @Test
    void testHappyPath() {

        // given
        when(port.getLvl(any())).thenReturn(InsuranceLevel.HIGH);

        // when
        final Patient patient = patientFactory.create(PATIENT_ID, PATIENT_NAME, PATIENT_HEALTH_CARE_ID,
            PATIENT_PHONE_NUMBER);

        // then
        assertEquals(PATIENT_ID, patient.getId());
        assertEquals(PATIENT_NAME, patient.getName());
        assertEquals(PATIENT_HEALTH_CARE_ID, patient.getHealthCareId().getValue());
        assertEquals(PATIENT_PHONE_NUMBER, patient.getPhoneNumber().getValue());
        assertEquals(InsuranceLevel.HIGH, patient.getInsuranceLevel());
    }

    @Test
    void shouldThrowException_WhenInsuranceLevelIsNotSatisfied() {

        // given
        when(port.getLvl(any())).thenReturn(InsuranceLevel.LOW);

        // when
        Executable executable = () -> patientFactory.create(PATIENT_ID, PATIENT_NAME, PATIENT_HEALTH_CARE_ID,
            PATIENT_PHONE_NUMBER);

        // then
        assertThrows(CannotCreatePatientException.class, executable);
    }

}
