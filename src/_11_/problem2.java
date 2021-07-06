package _11_;

import java.util.*;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]=sc.nextInt();
        }

        int max=arr[0],tempMax=arr[0];
        for (int i = 1; i < num; i++) {
            tempMax=Math.max(tempMax+arr[i],arr[i]);
            max = Math.max(tempMax,max);
        }
        System.out.println(max);
    }
}
