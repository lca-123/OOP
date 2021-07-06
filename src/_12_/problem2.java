package _12_;

import java.util.*;

/**
 * Read integer n, and then read n points. Find the closest pair of points and print their distance.
 * Keep two decimal places. "%.2f"
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] x = new int[num];
        int[] y = new int[num];
        for (int i = 0; i < num; i++) {
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        double res = Double.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                double dis = Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2));
                if(dis < res){
                    res = dis;
                }
            }
        }

        System.out.printf("%.2f",res);
    }


}


