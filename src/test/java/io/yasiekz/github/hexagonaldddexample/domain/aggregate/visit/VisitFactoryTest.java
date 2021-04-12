package io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.Doctor;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.doctor.DoctorPort;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.Patient;
import io.yasiekz.github.hexagonaldddexample.domain.aggregate.visit.patient.PatientPort;
import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VisitFactoryTest {

    private static final UUID VISIT_ID = UUID.randomUUID();
    private static final UUID DOCTOR_ID = UUID.randomUUID();
    private static final UUID PATIENT_ID = UUID.randomUUID();
    private static final VisitSlot VISIT_SLOT = VisitSlot.FIRST;
    private static final LocalDate NOW = LocalDate.now();

    @Mock
    private DoctorPort doctorPort;

    @Mock
    private PatientPort patientPort;

    @Mock
    private Patient patient;

    @Mock
    private Doctor doctor;

    private VisitFactory visitFactory;

    private static Stream<Arguments> provideWrongAppointmentDates() {
        return Stream.of(
            Arguments.of(NOW.plusDays(15)), // more than 14 days
            Arguments.of(NOW.minusDays(1)) // past date
        );
    }

    @BeforeEach
    void setUp() {
        visitFactory = new VisitFactory(doctorPort, patientPort);
        when(doctorPort.get(eq(DOCTOR_ID))).thenReturn(doctor);
        when(patientPort.get(eq(PATIENT_ID))).thenReturn(patient);
    }

    @Test
    @DisplayName("Should create Visit")
    void shouldReturnVisit_whenAllDataProvided() {

        // given
        when(doctor.isSlotFree(any(), any())).thenReturn(true);
        when(patient.isSlotFree(any(), any())).thenReturn(true);

        // when
        final Visit visit = visitFactory.create(VISIT_ID, PATIENT_ID, DOCTOR_ID, VISIT_SLOT, NOW);

        // then
        assertEquals(VISIT_ID, visit.getId());
        assertEquals(doctor, visit.getDoctor());
        assertEquals(patient, visit.getPatient());
        assertEquals(VISIT_SLOT, visit.getVisitSlot());
        assertEquals(NOW, visit.getAppointmentDate());
        assertNotNull(visit.getCreatedAt());
        verify(doctor).isSlotFree(eq(VISIT_SLOT), eq(NOW));
        verify(patient).isSlotFree(eq(VISIT_SLOT), eq(NOW));
    }

    @Test
    @DisplayName("Should throw exception when doctor hsa no free space")
    void shouldThrowException_whenDoctorHasNoFreeSpace() {

        // given
        when(doctor.isSlotFree(any(), any())).thenReturn(false);

        // when
        Executable executable = () -> visitFactory.create(VISIT_ID, PATIENT_ID, DOCTOR_ID, VISIT_SLOT, NOW);

        // then
        assertThrows(CannotCreateVisitException.class, executable);
    }

    @Test
    @DisplayName("Should throw exception when patient hsa no free space")
    void shouldThrowException_whenPatientHasNoFreeSpace() {

        // given
        when(doctor.isSlotFree(any(), any())).thenReturn(true);
        when(patient.isSlotFree(any(), any())).thenReturn(false);

        // when
        Executable executable = () -> visitFactory.create(VISIT_ID, PATIENT_ID, DOCTOR_ID, VISIT_SLOT, NOW);

        // then
        assertThrows(CannotCreateVisitException.class, executable);
    }

    @ParameterizedTest
    @MethodSource("provideWrongAppointmentDates")
    @DisplayName("Should throw exception when appointment date is invalid")
    void shouldThrowException_whenAppointmentDateIsInvalid(final LocalDate date) {

        // when
        Executable executable = () -> visitFactory.create(VISIT_ID, PATIENT_ID, DOCTOR_ID, VISIT_SLOT, date);

        // then
        assertThrows(CannotCreateVisitException.class, executable);
    }
}
