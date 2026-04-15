package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase19TrainConsistMgmntTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistApp.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(TrainConsistApp.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistApp.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG550"};

        assertTrue(TrainConsistApp.binarySearch(arr, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(TrainConsistApp.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};

        assertFalse(TrainConsistApp.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(TrainConsistApp.binarySearch(arr, "BG205"));
    }
}