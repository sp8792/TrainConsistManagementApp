import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistApp {

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
        public String toString() { return name + " -> " + capacity; }
    }

    public static void main(String[] args) {
        System.out.println("UC8 - Filter Passenger Bogies Using Streams\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("ALL Bogies:");
        bogies.forEach(System.out::println);
        System.out.println();

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);
        System.out.println();

        System.out.println("UC8 filtering completed ...");
    }
}