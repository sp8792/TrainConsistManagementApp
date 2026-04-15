import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        // Display UC2 banner
        System.out.println("UC2 - Add Passenger Bogies to Train");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies + "\n");

        // ---- DELETE (Remove bogie) ----
        passengerBogies.remove("AC Chair");

        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies + "\n");

        // ---- READ (Check existence) ----
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + hasSleeper + "\n");

        // ---- Final state ----
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully ...");
    }
}
