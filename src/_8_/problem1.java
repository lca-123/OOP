package _8_;

import java.util.*;

/**
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，
 * 规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
 * 给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[][] dp = new int[3][2];
        dp[1][1]=-arr[0];
        dp[2][1]=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[1][1]=Math.max(dp[1][1],-arr[i]);
            dp[1][0]=Math.max(dp[1][0],dp[1][1]+arr[i]);
            dp[2][1]=Math.max(dp[2][1],dp[1][0]-arr[i]);
            dp[2][0]=Math.max(dp[2][0],dp[2][1]+arr[i]);
        }
        System.out.println(Math.max(dp[1][0],dp[2][0]));
    }
}
