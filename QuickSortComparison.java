package DAA;

import java.util.*;

public class QuickSortComparison {

    static long detSteps = 0, randSteps = 0;
    static Random rand = new Random();

    // ---------- Partition Function ----------
    static int partition(int[] arr, int low, int high, boolean isDeterministic) {
        int pivot = arr[high];
        int i = low - 1;

        if (isDeterministic) {
            for (int j = low; j < high; j++) {
                detSteps++; // count comparisons
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        } else {
            for (int j = low; j < high; j++) {
                randSteps++; // count comparisons
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ---------- Randomized Partition ----------
    static int randomPartition(int[] arr, int low, int high) {
        int randIndex = low + rand.nextInt(high - low + 1);
        int temp = arr[randIndex];
        arr[randIndex] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high, false);
    }

    // ---------- Deterministic QuickSort ----------
    static void quickSortDet(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high, true);
            quickSortDet(arr, low, pi - 1);
            quickSortDet(arr, pi + 1, high);
        }
    }

    // ---------- Randomized QuickSort ----------
    static void quickSortRand(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            quickSortRand(arr, low, pi - 1);
            quickSortRand(arr, pi + 1, high);
        }
    }

    // ---------- Main Function ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }

        quickSortDet(arr1, 0, n - 1);
        quickSortRand(arr2, 0, n - 1);

        System.out.print("\nDeterministic QuickSort: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println("\nSteps (approx comparisons): " + detSteps);

        System.out.print("\nRandomized QuickSort: ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println("\nSteps (approx comparisons): " + randSteps);

        // ---------- Time & Space Complexity ----------
        System.out.println("\n=== Time and Space Complexity Analysis ===");
        System.out.println("Deterministic QuickSort:");
        System.out.println("  Average Time Complexity: O(n log n)");
        System.out.println("  Worst Time Complexity: O(n²)");
        System.out.println("  Space Complexity: O(log n)");

        System.out.println("\nRandomized QuickSort:");
        System.out.println("  Expected Time Complexity: O(n log n)");
        System.out.println("  Worst Time Complexity: O(n²) (rare)");
        System.out.println("  Space Complexity: O(log n)");

        sc.close();
    }
}
