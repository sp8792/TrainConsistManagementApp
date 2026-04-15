package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase14TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistApp.InvalidCapacityException {
        TrainConsistApp.PassengerBogie b =
                new TrainConsistApp.PassengerBogie("Sleeper", 72);

        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(
                TrainConsistApp.InvalidCapacityException.class,
                () -> new TrainConsistApp.PassengerBogie("AC", -10)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                TrainConsistApp.InvalidCapacityException.class,
                () -> new TrainConsistApp.PassengerBogie("AC", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(
                TrainConsistApp.InvalidCapacityException.class,
                () -> new TrainConsistApp.PassengerBogie("AC", 0)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistApp.InvalidCapacityException {
        TrainConsistApp.PassengerBogie b =
                new TrainConsistApp.PassengerBogie("First Class", 24);

        assertEquals("First Class", b.getType());
        assertEquals(24, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistApp.InvalidCapacityException {
        TrainConsistApp.PassengerBogie b1 =
                new TrainConsistApp.PassengerBogie("Sleeper", 72);

        TrainConsistApp.PassengerBogie b2 =
                new TrainConsistApp.PassengerBogie("AC Chair", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}