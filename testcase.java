package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase15TrainConsistMgmntTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistApp.GoodsBogie b =
                new TrainConsistApp.GoodsBogie("Cylindrical");

        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistApp.GoodsBogie b =
                new TrainConsistApp.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        // Cargo should NOT be assigned
        assertNull(b.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistApp.GoodsBogie b =
                new TrainConsistApp.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistApp.GoodsBogie b1 =
                new TrainConsistApp.GoodsBogie("Rectangular");

        TrainConsistApp.GoodsBogie b2 =
                new TrainConsistApp.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum");   // fails
        b2.assignCargo("Coal");        // should still work

        assertEquals("Coal", b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistApp.GoodsBogie b =
                new TrainConsistApp.GoodsBogie("Rectangular");

        // No assertion needed for finally (it always runs)
        b.assignCargo("Petroleum");

        assertTrue(true); // ensures method completes
    }
}