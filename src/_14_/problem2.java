package _14_;

import java.util.Scanner;

/**
 * 给定一个正整数n，寻找最少的完全平方数(1, 4, 9, 16…)使得它们的和等于n。
 * 例如，假如给定的正整数是12，则输出3，因为12 = 4 + 4 + 4；假如给定的正整数是13，则输出2，因为13 = 9 + 4
 * @author lca
 */
public class problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(method(num));
    }

    public static int method(int num){
        while(num % 4 ==0){
            num /= 4;
        }
        if(num % 8 == 7){
            return 4;
        }
        int a = 0;
        while(a*a < num){
            int b = (int) Math.pow(num - a*a,0.5);
            if(a*a + b*b == num){
                if(a!=0 && b!=0){
                    return 2;
                }
                else{
                    return 1;
                }
            }
            a++;
        }
        return 3;

    }
}
