package _2_;

import java.util.Scanner;

/**
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        if(a==0){
            if(b==0){
                System.out.println(-1);
            }else{
                System.out.printf("%.2f",-c/b);
            }
        }else{
            double d = b*b -4*a*c,x1,x2;
            if(Math.abs(d)<1e-8){
                x1=x2=-b/(2*a);
                System.out.printf("%.2f",x1);
            }else if(d<0){
                System.out.println(-1);
            }else{
                x1 = (-b + Math.sqrt(d))/(2*a);
                x2 = (-b - Math.sqrt(d))/(2*a);
                System.out.printf("%.2f %.2f",Math.max(x1,x2),Math.min(x1,x2));
            }
        }

    }
}
