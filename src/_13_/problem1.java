package _13_;

import java.util.Scanner;

/**
 * 0-1背包问题
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxW = sc.nextInt(),num = sc.nextInt();
        int[] weights = new int[num];
        int[] profits = new int[num];
        for (int i = 0; i < num; i++) {
            weights[i]=sc.nextInt();
            profits[i]=sc.nextInt();
        }

        int[] dp = new int[maxW+1];
        for (int i = 0; i < num; i++) {
            for (int j = maxW; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weights[i]] + profits[i]);
            }
        }

        System.out.println(dp[maxW]);
    }
}
