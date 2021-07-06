package _7_;

import java.util.*;

/**
 * 给定一定数目的纸币和一组硬币，求将纸币兑换成硬币的组合数目。
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money=sc.nextInt(),num=sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]=sc.nextInt();
        }
        //背包问题
//        int[][] res = new int[num+1][money+1];
//        for (int i = 0; i <= num; i++) {
//            for (int j = 0; j <= money; j++) {
//                if(i==0){
//                    res[i][j]=0;
//                }else if(j<arr[i-1]){
//                    res[i][j]=res[i-1][j];
//                }else if(j==arr[i-1]){
//                    res[i][j] = res[i-1][j]+1;
//                }else {
//                    res[i][j]=res[i-1][j]+res[i][j-arr[i-1]];
//                }
//            }
//        }
        //优化背包问题
        int[] ans = new int[money+1];
        for (int i = 0; i < num; i++) {
            ans[arr[i]] += 1;
            for(int j = arr[i] + 1; j <= money; j++){
                ans[j] += ans[j - arr[i]];
            }
        }
        System.out.println(ans[money]);
    }
}
