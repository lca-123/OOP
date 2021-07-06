package _8_;

import java.util.*;

/**
 * 设有n个正整数，将它们连接成一排，组成一个最大的多位整数。
 * 例如：n=3时，3个整数13，312，343，连成的最大整数为34331213。
 * 又如：n=4时，4个整数7，13，4，246，连成的最大整数为7424613。
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i]="" + sc.nextInt();
        }
        Arrays.sort(arr,(x,y)->(x+y).compareTo(y+x));
        StringBuilder ans= new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            ans.append(arr[i]);
        }
        System.out.println(ans);
    }
}
