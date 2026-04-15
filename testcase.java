ackage app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase13TrainConsistMgmntTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("A", 50));
        list.add(new TrainConsistApp.Bogie("B", 70));

        List<TrainConsistApp.Bogie> result = TrainConsistApp.filterWithLoop(list);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("A", 40));
        list.add(new TrainConsistApp.Bogie("B", 80));

        List<TrainConsistApp.Bogie> result = TrainConsistApp.filterWithStream(list);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("A", 30));
        list.add(new TrainConsistApp.Bogie("B", 90));
        list.add(new TrainConsistApp.Bogie("C", 70));

        List<TrainConsistApp.Bogie> loopResult = TrainConsistApp.filterWithLoop(list);
        List<TrainConsistApp.Bogie> streamResult = TrainConsistApp.filterWithStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new TrainConsistApp.Bogie("X", i));
        }

        long start = System.nanoTime();
        TrainConsistApp.filterWithLoop(list);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new TrainConsistApp.Bogie("X", i % 100));
        }

        List<TrainConsistApp.Bogie> result = TrainConsistApp.filterWithStream(list);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}