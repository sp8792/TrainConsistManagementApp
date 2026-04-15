import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UseCase8TrainConsistMgmntTest {

    // Lightweight test Bogie model
    static class Bogie {
        final String name;
        final int capacity;
        Bogie(String name, int capacity) { this.name = name; this.capacity = capacity; }
    }

    private List<Bogie> sampleBogiesAll() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("General", 90));
        return list;
    }

    private List<Bogie> filterByCapacity(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = filterByCapacity(sampleBogiesAll(), 70);
        // Expect Sleeper(72) and General(90)
        assertEquals(2, result.size());
        List<Integer> caps = result.stream().map(b -> b.capacity).collect(Collectors.toList());
        assertTrue(caps.contains(72));
        assertTrue(caps.contains(90));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Edge", 70));
        List<Bogie> result = filterByCapacity(list, 70);
        assertTrue(result.isEmpty(), "Bogies with capacity exactly equal to threshold must be excluded");
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Small", 50));
        list.add(new Bogie("Medium", 60));
        List<Bogie> result = filterByCapacity(list, 70);
        assertTrue(result.isEmpty(), "Bogies with capacity less than threshold must be excluded");
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 71));
        list.add(new Bogie("B", 72));
        list.add(new Bogie("C", 80));
        list.add(new Bogie("D", 30));
        List<Bogie> result = filterByCapacity(list, 70);
        assertEquals(3, result.size());
        List<String> names = result.stream().map(b -> b.name).collect(Collectors.toList());
        assertTrue(names.contains("A"));
        assertTrue(names.contains("B"));
        assertTrue(names.contains("C"));
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Low1", 10));
        list.add(new Bogie("Low2", 20));
        List<Bogie> result = filterByCapacity(list, 70);
        assertTrue(result.isEmpty(), "When no bogie matches, filtered list must be empty");
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("X", 71));
        list.add(new Bogie("Y", 75));
        list.add(new Bogie("Z", 90));
        List<Bogie> result = filterByCapacity(list, 70);
        assertEquals(list.size(), result.size(), "All bogies should match and be returned");
        // ensure original contents preserved in result
        List<Integer> originalCaps = list.stream().map(b -> b.capacity).collect(Collectors.toList());
        List<Integer> resultCaps = result.stream().map(b -> b.capacity).collect(Collectors.toList());
        assertTrue(resultCaps.containsAll(originalCaps));
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();
        List<Bogie> result = filterByCapacity(empty, 70);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Filtering an empty list must return an empty list");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = sampleBogiesAll();
        List<Bogie> copy = new ArrayList<>(original);
        filterByCapacity(original, 60);
        // original list size must remain same (no mutation)
        assertEquals(copy.size(), original.size(), "Original list must not be modified by filtering");
        // also check elements unchanged by comparing capacities sequence
        List<Integer> origCaps = original.stream().map(b -> b.capacity).collect(Collectors.toList());
        List<Integer> copyCaps = copy.stream().map(b -> b.capacity).collect(Collectors.toList());
        assertEquals(copyCaps, origCaps);
    }
}