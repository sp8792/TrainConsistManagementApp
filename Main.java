package app;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    // Goods Bogie model
    public static class GoodsBogie {
        private final String type;
        private final String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    // UC12 Safety validation method
    public static boolean isSafe(List<GoodsBogie> bogies) {
        if (bogies == null) return true;

        return bogies.stream().allMatch(b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum")
        );
    }

    public static void main(String[] args) {

        System.out.println("UC12 - Safety Compliance Check for Goods Bogies\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // invalid

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean safe = isSafe(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + safe);

        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed ...");
    }
}