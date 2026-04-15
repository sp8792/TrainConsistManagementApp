package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmntTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistApp.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistApp.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET123"));
        assertFalse(TrainConsistApp.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-Ab"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistApp.isValidTrainId(""));
        assertFalse(TrainConsistApp.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ABC"));
    }
}