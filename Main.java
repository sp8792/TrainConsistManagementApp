package app;

public class TrainConsistApp {

    // Bubble Sort method
    public static void bubbleSort(int[] arr) {
        if (arr == null) return;

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {          // passes
            for (int j = 0; j < n - i - 1; j++) {  // comparisons
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("UC16 - Manual Sorting using Bubble Sort\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // Sorting
        bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed ...");
    }
}