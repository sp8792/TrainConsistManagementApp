import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UseCase9TrainConsistMgnntTest {

    // Local lightweight Bogie model for tests
    static class Bogie {
        final String name;
        final int capacity;
        Bogie(String name, int capacity) { this.name = name; this.capacity = capacity; }
    }

    private List<Bogie> sampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Sleeper", 78));
        list.add(new Bogie("AC Chair", 60));
        return list;
    }

    private Map<String, List<Bogie>> groupByName(List<Bogie> list) {
        return list.stream().collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped = groupByName(sampleBogies());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped = groupByName(sampleBogies());
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> grouped = groupByName(sampleBogies());
        assertEquals(3, grouped.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> grouped = groupByName(new ArrayList<>());
        assertNotNull(grouped);
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("Sleeper", 70));
        Map<String, List<Bogie>> grouped = groupByName(list);
        assertEquals(1, grouped.keySet().size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> grouped = groupByName(sampleBogies());
        assertTrue(grouped.keySet().containsAll(List.of("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> grouped = groupByName(sampleBogies());
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = sampleBogies();
        List<Bogie> copy = new ArrayList<>(original);
        groupByName(original);
        assertEquals(copy.size(), original.size());
        List<Integer> origCaps = original.stream().map(b -> b.capacity).collect(Collectors.toList());
        List<Integer> copyCaps = copy.stream().map(b -> b.capacity).collect(Collectors.toList());
        assertEquals(copyCaps, origCaps);
    }
}