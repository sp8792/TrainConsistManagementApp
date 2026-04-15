package app;

import java.util.Arrays;

public class TrainConsistApp {

    // Sorting method using Arrays.sort()
    public static void sortBogieNames(String[] arr) {
        if (arr == null) return;
        Arrays.sort(arr);
    }

    public static void main(String[] args) {

        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()\n");

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting
        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed ...");
    }
}