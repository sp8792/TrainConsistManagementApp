package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistApp {

    // Bogie model
    public static class Bogie {
        private final String type;
        private final int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        if (bogies == null) return result;

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        if (bogies == null) return new ArrayList<>();

        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("UC13 - Performance Comparison (Loops vs Streams)\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Type" + i, (i % 100) + 1));
        }

        // Loop timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        // Stream timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();

        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed ...");
    }
}