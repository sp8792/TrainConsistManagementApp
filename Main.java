package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TrainConsistApp {

    // Make Bogie public so tests can reference it
    public static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Bogie)) return false;
            Bogie bogie = (Bogie) o;
            return capacity == bogie.capacity && Objects.equals(name, bogie.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, capacity);
        }
    }

    // Reusable sample data used by main and optionally by tests
    public static List<Bogie> sampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        return Collections.unmodifiableList(bogies);
    }

    // Public helper to compute total seats (tests should call this)
    public static int totalSeats(List<Bogie> bogies) {
        if (bogies == null) {
            return 0; // chosen behavior: treat null as empty list
        }
        return bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();
    }

    // Public helper to group bogies by name (optional for UC9 tests)
    public static Map<String, List<Bogie>> groupByName(List<Bogie> bogies) {
        if (bogies == null) {
            return Collections.emptyMap();
        }
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {
        System.out.println("UC10 - Count Total Seats in Train\n");
        List<Bogie> bogies = sampleBogies();
        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        int total = totalSeats(bogies);
        System.out.println("\nTotal Seating Capacity of Train: " + total + "\n");
        System.out.println("UC10 aggregation completed ...");
    }
}