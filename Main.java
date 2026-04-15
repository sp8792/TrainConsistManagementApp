package app;

import java.util.Arrays;

public class TrainConsistApp {

    // Binary Search method
    public static boolean binarySearch(String[] arr, String key) {
        if (arr == null || arr.length == 0 || key == null) return false;

        // Ensure sorted (important precondition)
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                return true; // found
            } else if (cmp < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("UC19 - Binary Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        Arrays.sort(bogieIds);
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed ...");
    }
}