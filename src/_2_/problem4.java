package _2_;

import java.util.Scanner;

/**
 * @author lca
 */
public class problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble(),S=-1;
        if(a+b>c&&b+c>a&&a+c>b){
            double p=(a+b+c)/2;
            S=Math.sqrt((p-a)*(p-b)*(p-c)*p);
            System.out.printf("%.3f",S);
        }else{
            System.out.println("-1");
        }

    }
}
