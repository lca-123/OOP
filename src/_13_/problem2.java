package _13_;

import java.util.*;

/**
 * Two dimensional integer knapsack problem
 * Read an integer W and an integer V, which are the maximum allowed weight and volume capacity of a knapsack, respecitively.
 * Read an integer n and then n types of item; each item type has four attributes: weight (integer), volume(integer), profit (integer), and number of items (integer).
 * An item cannot be divided into pieces.
 * Solve the knapsack problem and print total profit of packed items.
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxW = sc.nextInt(),maxV = sc.nextInt();
        int num = sc.nextInt();
        int[] weights = new int[num];
        int[] volumes = new int[num];
        int[] profits = new int[num];
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            weights[i]=sc.nextInt();
            volumes[i]=sc.nextInt();
            profits[i]=sc.nextInt();
            nums[i]=sc.nextInt();
        }
        int[][] dp = new int[maxW+1][maxV+1];

        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                for (int k = maxW; k >= weights[i]; k--) {
                    for (int l = maxV; l >= volumes[i]; l--) {
                        dp[k][l] = Math.max(dp[k][l],dp[k-weights[i]][l-volumes[i]]+profits[i]);
                    }
                }
            }
        }

        System.out.println(dp[maxW][maxV]);
    }
}
