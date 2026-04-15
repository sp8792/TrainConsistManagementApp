package app;

public class TrainConsistApp {

    // Search method with fail-fast validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ---- FAIL-FAST VALIDATION ----
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // ---- SEARCH LOGIC ----
        for (String id : bogieIds) {
            if (key.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("UC20 - Exception Handling During Search\n");

        String[] bogieIds = {};   // empty case
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);

            if (found) {
                System.out.println("Bogie " + searchId + " found.");
            } else {
                System.out.println("Bogie " + searchId + " NOT found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed ...");
    }
}