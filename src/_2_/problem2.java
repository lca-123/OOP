package _2_;

import java.util.Scanner;

/**
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
        double res = (a*b*Math.pow((1+b),c))/(Math.pow((1+b),c)-1);
        System.out.printf("%.2f",res);

    }
}
