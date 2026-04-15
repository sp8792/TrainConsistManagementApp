package app;

public class TrainConsistApp {

    // Linear Search method
    public static boolean linearSearch(String[] arr, String key) {
        if (arr == null || key == null) return false;

        for (String id : arr) {
            if (key.equals(id)) {   // safe string comparison
                return true;        // found → stop early
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("UC18 - Linear Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = linearSearch(bogieIds, searchId);

        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found.");
        }

        System.out.println("\nUC18 search completed ...");
    }
}