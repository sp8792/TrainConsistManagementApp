package app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UseCase10TrainConsistMgnntTest {

    @Test
    void testReduce_TotalSeatCalculation_UsesProductionData() {
        List<TrainConsistApp.Bogie> bogies = TrainConsistApp.sampleBogies();
        int total = TrainConsistApp.totalSeats(bogies);
        assertEquals(72 + 56 + 24 + 70, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("A", 30));
        list.add(new TrainConsistApp.Bogie("B", 40));
        list.add(new TrainConsistApp.Bogie("C", 50));
        assertEquals(120, TrainConsistApp.totalSeats(list));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("Solo", 88));
        assertEquals(88, TrainConsistApp.totalSeats(list));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistApp.Bogie> empty = new ArrayList<>();
        assertEquals(0, TrainConsistApp.totalSeats(empty));
    }

    @Test
    void testReduce_NullListReturnsZero() {
        assertEquals(0, TrainConsistApp.totalSeats(null));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("X", 10));
        list.add(new TrainConsistApp.Bogie("Y", 20));
        assertEquals(30, TrainConsistApp.totalSeats(list));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistApp.Bogie> list = TrainConsistApp.sampleBogies();
        int expected = list.stream().mapToInt(TrainConsistApp.Bogie::getCapacity).sum();
        assertEquals(expected, TrainConsistApp.totalSeats(list));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistApp.Bogie> original = TrainConsistApp.sampleBogies();
        List<TrainConsistApp.Bogie> copy = new ArrayList<>(original);
        TrainConsistApp.totalSeats(original);
        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).getCapacity(), original.get(i).getCapacity());
        }
    }

    @Test
    void testGroupByName_SumsAndCounts() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("S", 10));
        list.add(new TrainConsistApp.Bogie("S", 20));
        list.add(new TrainConsistApp.Bogie("A", 5));

        Map<String, List<TrainConsistApp.Bogie>> grouped = TrainConsistApp.groupByName(list);
        assertEquals(2, grouped.get("S").size());
        int sumS = grouped.get("S").stream().mapToInt(TrainConsistApp.Bogie::getCapacity).sum();
        assertEquals(30, sumS);
        assertEquals(1, grouped.get("A").size());
    }

    @Test
    void testNegativeAndZeroCapacities() {
        List<TrainConsistApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistApp.Bogie("Neg", -5));
        list.add(new TrainConsistApp.Bogie("Zero", 0));
        list.add(new TrainConsistApp.Bogie("Pos", 10));
        // Behavior: sum includes negatives as-is
        assertEquals(5, TrainConsistApp.totalSeats(list));
    }

    @Test
    void testSampleBogiesIsUnmodifiable() {
        List<TrainConsistApp.Bogie> sample = TrainConsistApp.sampleBogies();
        assertThrows(UnsupportedOperationException.class, () -> sample.add(new TrainConsistApp.Bogie("X", 1)));
    }
}