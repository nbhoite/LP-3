package DAA;

import java.util.*;

public class ZeroOneKnapsack {

    // ---------- 0/1 Knapsack using Dynamic Programming ----------
    static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;  // Base case
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W]; // Maximum value
    }

    // ---------- Main Function ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        int maxValue = knapsack(W, wt, val, n);
        System.out.println("Maximum value in 0-1 Knapsack = " + maxValue);

        // ---------- Time & Space Complexity ----------
        System.out.println("\n=== Time and Space Complexity Analysis ===");
        System.out.println("Time Complexity: O(n * W)");
        System.out.println("Space Complexity: O(n * W)");

        sc.close();
    }
}
